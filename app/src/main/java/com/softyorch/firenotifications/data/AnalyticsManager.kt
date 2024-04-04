package com.softyorch.firenotifications.data

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.softyorch.firenotifications.data.model.AnalyticModel
import javax.inject.Inject

class AnalyticsManager @Inject constructor(private val analytics: FirebaseAnalytics) {

    fun example() {
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN) {
            param(FirebaseAnalytics.Param.SCORE, "100")
        }
    }

    fun example2() {
        analytics.logEvent("SoftYorch") {
            param("Soft", "pro")
            param("Yorch", 100)
        }
    }

    fun sendEvent(analyticsModel: AnalyticModel) {
        analytics.logEvent(analyticsModel.title) {
            analyticsModel.apply {
                analyticsString.map { param(it.first, it.second) }
                analyticsDouble.map { param(it.first, it.second) }
                analyticsLong.map { param(it.first, it.second) }
                analyticsBundle.map { param(it.first, it.second) }
                analyticsBundleArray.map { param(it.first, it.second) }
            }
        }
    }

}