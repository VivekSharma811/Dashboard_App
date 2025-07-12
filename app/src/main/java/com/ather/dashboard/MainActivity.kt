package com.ather.dashboard

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.ather.dashboard.dashboard.presentation.DashboardScreen
import com.ather.dashboard.dashboard.presentation.DashboardUIEvent
import com.ather.dashboard.dashboard.presentation.DashboardViewModel
import com.ather.dashboard.dashboard.presentation.OdometerReadingReceiver
import com.ather.dashboard.dashboard.utils.ODOMETER_READING
import com.ather.dashboard.ui.theme.DashboardTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: DashboardViewModel
    private var receiver: OdometerReadingReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        receiver = OdometerReadingReceiver {
            viewModel.onUIEvent(DashboardUIEvent.OnOdometerReadingResult(it))
        }

        registerReceiver(receiver, IntentFilter(ODOMETER_READING), RECEIVER_NOT_EXPORTED)

        setContent {
            DashboardTheme {
                DashboardScreen(viewModel)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        receiver?.let { unregisterReceiver(receiver) }
    }
}
