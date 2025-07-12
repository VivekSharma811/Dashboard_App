package com.ather.dashboard.dashboard.presentation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ather.dashboard.dashboard.data.OdometerReading
import com.ather.dashboard.dashboard.utils.DATA

/**
 * Broadcast Receiver to receive Odometer Reading from Odometer App
 * */
class OdometerReadingReceiver(private val onResult: (OdometerReading) -> Unit) :
    BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.getParcelableExtra<OdometerReading>(DATA)?.let { onResult(it) }
    }
}
