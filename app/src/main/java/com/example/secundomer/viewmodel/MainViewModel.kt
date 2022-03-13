package com.example.secundomer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.secundomer.di.StopwatchModule
import com.example.secundomer.model.Stopwatch
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val stopwatch: Stopwatch
) : ViewModel() {

    val ticker: StateFlow<String> = stopwatch.ticker

    fun onStartClicked() {
        stopwatch.start()
    }

    fun onPauseClicked() {
        stopwatch.pause()
    }

    fun onStopClicked() {
        stopwatch.stop()
    }
}