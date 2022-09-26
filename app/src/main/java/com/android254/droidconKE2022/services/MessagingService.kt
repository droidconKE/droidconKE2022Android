package com.android254.droidconKE2022.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.android254.droidconKE2022.R
import com.android254.presentation.activity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("FCMMESSAGE", "Message data payload: ${remoteMessage.data}")
            // Diplay Notification
            showNotification(
                remoteMessage.data["title"].orEmpty(),
                remoteMessage.data["message"].orEmpty()
            )
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("FCMMESSAGE", "Message Notification Title: ${it.title}")
            Log.d("FCMMESSAGE", "Message Notification Body: ${it.body}")

            showNotification(
                remoteMessage.notification?.title.orEmpty(),
                remoteMessage.notification?.body.orEmpty()
            )
        }
    }

    /**
     * Creates and shows a simple notification containing the received FCM message.
     * @param title The title of the notification.
     * @param message The body of the notification.
     */
    private fun showNotification(title: String, message: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.default_notification_channel_id)
            val descriptionText = getString(R.string.fcm_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(
                getString(R.string.default_notification_channel_id),
                name,
                importance
            )
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(mChannel)
        }

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        val notificationSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(
            applicationContext,
            getString(R.string.default_notification_channel_id)
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setSound(notificationSoundUri)
            .setContentIntent(pendingIntent)
            .setOnlyAlertOnce(true)
        val notificationManager = ContextCompat.getSystemService(
            applicationContext,
            NotificationManager::class.java
        ) as NotificationManager
        notificationManager.notify(1, notificationBuilder.build())
    }
}