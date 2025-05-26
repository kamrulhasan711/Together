package model


import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class Together : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val extras = sbn.notification.extras
        val title = extras.getString("android.title")
        val text = extras.getCharSequence("android.text")
        val app = sbn.packageName

        Log.d("Notification", "App: $app, Title: $title, Text: $text")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.d("Notification", "Notification removed")
    }
}
