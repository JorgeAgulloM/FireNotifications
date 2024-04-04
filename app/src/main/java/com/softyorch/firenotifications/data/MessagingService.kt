package com.softyorch.firenotifications.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
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
            message.data.forEach { key, value ->
                Log.i("LOGTAG", "Para la clave $key el valor $value")
            }
        } else {
            Log.w("LOGTAG", "Message: No hay mensages")
        }
    }

}