package com.softyorch.firenotifications.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class TopicManager @Inject constructor(private val messaging: FirebaseMessaging) {

    companion object {
        const val FOOTBALL_TOPIC = "football_topic"
        const val BASKETBALL_TOPIC = "basketball_topic"
        const val PETANCA_TOPIC = "petanca_topic"
    }

    fun subscribeToTopic(topic: String) {
        messaging.subscribeToTopic(topic).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("LOGTAG", "Suscrito al topic $topic")
            } else {
                Log.e("LOGTAG", "Error al suscribirse al topic $topic")
            }
        }
    }

    fun unSubscribeToTopic(topic: String) {
        messaging.unsubscribeFromTopic(topic).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("LOGTAG", "Suscribción cancelada al topic $topic")
            } else {
                Log.e("LOGTAG", "Error al cancelar la suscribibción al topic $topic")
            }
        }
    }
}