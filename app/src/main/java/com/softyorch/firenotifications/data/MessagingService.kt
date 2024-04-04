package com.softyorch.firenotifications.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Resources.Theme
import android.media.RingtoneManager
import android.media.audiofx.DynamicsProcessing.Config.Builder
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.softyorch.firenotifications.MainActivity
import com.softyorch.firenotifications.R
import javax.inject.Inject

class MessagingService @Inject constructor(): FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        sendRegistrationToken(token)
    }

    private fun sendRegistrationToken(token: String) {
        Log.i("LOGTAG", "Firebase token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        if (message.data.isNotEmpty()) {
            message.data.forEach { (key, value) ->
                Log.i("LOGTAG", "Para la clave $key el valor $value")
            }
        } else {
            Log.w("LOGTAG", "Message: No hay mensages")
        }

        message.notification?.let{
            val body = it.body.orEmpty()
            val title = it.title.orEmpty()
            createNotification(title, body)
        }

    }

    private fun createNotification(title: String, body: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }

        val pendingIntent = PendingIntent.getActivity(this, 999, intent, PendingIntent.FLAG_IMMUTABLE)
        val sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        val channelId = getString(R.string.default_channel)

        val notificationBuilder = NotificationCompat.Builder(this, "")
            .setSmallIcon(R.drawable.ic_android)
            .setColor(resources.getColor(R.color.orange, theme) )
            .setContentTitle("Notification title: $title")
            .setContentText("Notification body: $body")
            .setAutoCancel(true)
            .setSound(sound)
            .setContentIntent(pendingIntent)
            .setChannelId(channelId)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Channel things
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                /* id = */ channelId,
                /* name = */ "Promotion",
                /* importance = */ NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notificationBuilder.build())

    }

}