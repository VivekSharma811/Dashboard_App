package com.ather.dashboard.dashboard.presentation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.ather.dashboard.dashboard.utils.DATA
import com.ather.odometer.odometer.data.OdometerReading

/**
 * Broadcast Receiver to receive Odometer Reading from Odometer App
 * */
class OdometerReadingReceiver(private val onResult: (OdometerReading) -> Unit) :
    BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.getParcelableExtra<OdometerReading>(DATA)
        data?.let { onResult(it) }
    }
}
