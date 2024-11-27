package ru.popkov.navigator.services

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.android.gms.cloudmessaging.CloudMessage
import com.google.android.gms.cloudmessaging.Rpc
import com.google.firebase.messaging.Constants
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.MessagingAnalytics
import com.google.firebase.messaging.RemoteMessage
import ru.popkov.navigator.MainActivity
import ru.popkov.navigator.R

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class NotificationService : FirebaseMessagingService() {
    private companion object {
        private const val CHANNEL_ID = "navigator_channel"
        private const val ACTION_REMOTE_INTENT: String = "com.google.android.c2dm.intent.RECEIVE"
        private const val ACTION_NEW_TOKEN: String = "com.google.firebase.messaging.NEW_TOKEN"
        private const val EXTRA_TOKEN: String = "token"
        private const val RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE = 10
    }

    private var rpc: Rpc? = null
    private val recentlyReceivedMessageIds = ArrayDeque<String>(
        RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE
    )

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (message.notification == null || message.data.isEmpty()) return

        val intent = Intent(this, MainActivity::class.java).apply {
            action = Intent.ACTION_VIEW
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Navigator notification",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }

    override fun handleIntent(intent: Intent?) {
        val action = intent?.action
        when (action) {
            ACTION_REMOTE_INTENT -> handleMessageIntent(intent)
            ACTION_NEW_TOKEN -> onNewToken(intent.getStringExtra(EXTRA_TOKEN) ?: return)
            else -> Log.d(Constants.TAG, "Unknown intent action: " + intent?.action)
        }
    }

    private fun handleMessageIntent(intent: Intent) {
        val messageId = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID)
        if (!alreadyReceivedMessage(messageId)) {
            passMessageIntentToSdk(intent)
        }
        getRpc(this).messageHandled(CloudMessage(intent))
    }

    private fun passMessageIntentToSdk(intent: Intent) {
        var messageType = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE)
        if (messageType == null) {
            messageType = Constants.MessageTypes.MESSAGE
        }
        when (messageType) {
            Constants.MessageTypes.MESSAGE -> {
                MessagingAnalytics.logNotificationReceived(intent)
                dispatchMessage(intent)
            }

            Constants.MessageTypes.DELETED -> onDeletedMessages()
            Constants.MessageTypes.SEND_EVENT -> onMessageSent(
                intent.getStringExtra(Constants.MessagePayloadKeys.MSGID)!!
            )

            Constants.MessageTypes.SEND_ERROR -> onSendError(
                getMessageId(intent)!!,
                Exception(intent.getStringExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR))
            )

            else -> Log.w(Constants.TAG, "Received message with unknown type: $messageType")
        }
    }

    private fun dispatchMessage(intent: Intent) {
        var data = intent.extras
        if (data == null) data = Bundle()
        data.remove("androidx.content.wakelockid")
        onMessageReceived(RemoteMessage(data))
    }

    private fun getMessageId(intent: Intent): String? {
        var messageId = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID)
        if (messageId == null) {
            messageId = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER)
        }
        return messageId
    }

    private fun getRpc(context: Context): Rpc {
        if (rpc == null) {
            rpc = Rpc(context.applicationContext)
        }
        return rpc!!
    }

    private fun alreadyReceivedMessage(messageId: String?): Boolean {
        if (messageId.isNullOrEmpty()) return false
        if (recentlyReceivedMessageIds.contains(messageId)) {
            if (Log.isLoggable(Constants.TAG, Log.DEBUG)) {
                Log.d(Constants.TAG, "Received duplicate message: $messageId")
            }
            return true
        }

        if (recentlyReceivedMessageIds.size >= RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE) {
            recentlyReceivedMessageIds.removeFirst()
        }

        recentlyReceivedMessageIds.add(messageId)
        return false
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "Refreshed token: $token")
    }
}
