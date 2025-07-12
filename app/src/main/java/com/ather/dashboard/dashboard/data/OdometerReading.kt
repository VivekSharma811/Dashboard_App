package com.ather.dashboard.dashboard.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * DTO for interacting with Odometer App
 * */
@Parcelize
data class OdometerReading(
    val speed: Int = 0,
    val odo: Float = 0f,
    val range: Int = 0,
    val mode: String = "",
    val trip: Float = 0f
) : Parcelable
