package com.softyorch.firenotifications.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import javax.inject.Inject

class MessagingService @Inject constructor(): FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        sendRegistrationToken(token)
    }

    private fun sendRegistrationToken(token: String) {
        Log.i("LOGTAG", "Firebase token: $token")
    }

}