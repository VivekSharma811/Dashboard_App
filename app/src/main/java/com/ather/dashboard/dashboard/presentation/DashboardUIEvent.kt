package com.ather.dashboard.dashboard.presentation

import com.ather.odometer.odometer.data.OdometerReading

/**
 * UI Event for Dashboard Screen
 * */
sealed class DashboardUIEvent {

    data class OnOdometerReadingResult(val reading: OdometerReading) : DashboardUIEvent()
}
