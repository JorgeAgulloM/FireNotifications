package com.softyorch.firenotifications.data.model

import android.os.Bundle

data class AnalyticModel(
    val title: String,
    val analyticsString: List<Pair<String, String>> = emptyList(),
    val analyticsDouble: List<Pair<String, Double>> = emptyList(),
    val analyticsLong: List<Pair<String, Long>> = emptyList(),
    val analyticsBundle: List<Pair<String, Bundle>> = emptyList(),
    val analyticsBundleArray: List<Pair<String, Array<Bundle>>> = emptyList(),
)
