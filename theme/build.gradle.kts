plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
}

android {
    namespace = "ru.popkov.navigator.theme"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.activity)
}