package com.softyorch.firenotifications.ui

import androidx.lifecycle.ViewModel
import com.softyorch.firenotifications.data.AnalyticsManager
import com.softyorch.firenotifications.data.model.AnalyticModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val analytics: AnalyticsManager): ViewModel() {

    fun onLoginSelectedExample() {
        // All my logic
        analytics.example()
        analytics.example2()
    }

    fun customEvent() {
        val analyticModel = AnalyticModel(title = "New custom event", analyticsString = listOf(Pair("CustomString", "String")))
        analytics.sendEvent(analyticModel)
    }

}
