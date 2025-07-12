package com.ather.dashboard.dashboard.presentation

import androidx.compose.runtime.Stable

@Stable
data class DashboardUIState(
    val eventCount: Int = 0,
    val rpm: Float = 0f
)
