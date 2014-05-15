growthpush-android
==================

GrowthPush SDK for Android

## How to track "Launch via push notification xxx"

1. Add growthpush-launch-via-push-notification.jar to your project
1. Change BroadcastReceiver class to LaunchViaPushNotificationBroadcastReceiver.

```xml
<receiver
    android:name="com.growthpush.LaunchViaPushNotificationBroadcastReceiver"
    android:permission="com.google.android.c2dm.permission.SEND" >
    <intent-filter>
        <action android:name="com.google.android.c2dm.intent.RECEIVE" />
        <action android:name="com.google.android.c2dm.intent.REGISTRATION" />

        <category android:name="com.growthpush.growthpushsample" />
    </intent-filter>
</receiver>
```
