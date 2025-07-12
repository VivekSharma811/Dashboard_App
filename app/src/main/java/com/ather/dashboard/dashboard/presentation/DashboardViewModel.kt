package com.ather.dashboard.dashboard.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUIState())
    val uiState = _uiState.asStateFlow()

    fun onUIEvent(event: DashboardUIEvent) {
        viewModelScope.launch {
            when(event) {
                is DashboardUIEvent.OnOdometerReadingResult -> {
                    Log.d("DebugResult", "VM: ${event.reading.speed}")
                    _uiState.update {
                        it.copy(
                            eventCount = it.eventCount + 1,
                            rpm = (event.reading.speed * 1000 / 60)/ 1.5f    // Assumed Circumference as 1.5f
                        )
                    }
                }
            }
        }
    }
}
