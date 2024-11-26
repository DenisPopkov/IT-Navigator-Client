// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: settings.proto

package ru.popkov.android.core.feature.datastore;

/**
 * Protobuf type {@code ProtoSettings}
 */
public  final class ProtoSettings extends
    com.google.protobuf.GeneratedMessageLite<
        ProtoSettings, ProtoSettings.Builder> implements
    // @@protoc_insertion_point(message_implements:ProtoSettings)
    ProtoSettingsOrBuilder {
  private ProtoSettings() {
  }
  public static final int IS_LIGHT_FIELD_NUMBER = 1;
  private boolean isLight_;
  /**
   * <code>bool is_light = 1;</code>
   * @return The isLight.
   */
  @java.lang.Override
  public boolean getIsLight() {
    return isLight_;
  }
  /**
   * <code>bool is_light = 1;</code>
   * @param value The isLight to set.
   */
  private void setIsLight(boolean value) {
    
    isLight_ = value;
  }
  /**
   * <code>bool is_light = 1;</code>
   */
  private void clearIsLight() {
    
    isLight_ = false;
  }

  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ru.popkov.android.core.feature.datastore.ProtoSettings parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(ru.popkov.android.core.feature.datastore.ProtoSettings prototype) {
    return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code ProtoSettings}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ru.popkov.android.core.feature.datastore.ProtoSettings, Builder> implements
      // @@protoc_insertion_point(builder_implements:ProtoSettings)
      ru.popkov.android.core.feature.datastore.ProtoSettingsOrBuilder {
    // Construct using ru.popkov.android.core.feature.datastore.ProtoSettings.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>bool is_light = 1;</code>
     * @return The isLight.
     */
    @java.lang.Override
    public boolean getIsLight() {
      return instance.getIsLight();
    }
    /**
     * <code>bool is_light = 1;</code>
     * @param value The isLight to set.
     * @return This builder for chaining.
     */
    public Builder setIsLight(boolean value) {
      copyOnWrite();
      instance.setIsLight(value);
      return this;
    }
    /**
     * <code>bool is_light = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsLight() {
      copyOnWrite();
      instance.clearIsLight();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:ProtoSettings)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ru.popkov.android.core.feature.datastore.ProtoSettings();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "isLight_",
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<ru.popkov.android.core.feature.datastore.ProtoSettings> parser = PARSER;
        if (parser == null) {
          synchronized (ru.popkov.android.core.feature.datastore.ProtoSettings.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<ru.popkov.android.core.feature.datastore.ProtoSettings>(
                      DEFAULT_INSTANCE);
              PARSER = parser;
            }
          }
        }
        return parser;
    }
    case GET_MEMOIZED_IS_INITIALIZED: {
      return (byte) 1;
    }
    case SET_MEMOIZED_IS_INITIALIZED: {
      return null;
    }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:ProtoSettings)
  private static final ru.popkov.android.core.feature.datastore.ProtoSettings DEFAULT_INSTANCE;
  static {
    ProtoSettings defaultInstance = new ProtoSettings();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      ProtoSettings.class, defaultInstance);
  }

  public static ru.popkov.android.core.feature.datastore.ProtoSettings getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<ProtoSettings> PARSER;

  public static com.google.protobuf.Parser<ProtoSettings> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

