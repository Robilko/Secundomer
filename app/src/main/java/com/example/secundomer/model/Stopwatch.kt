package com.example.secundomer.model


import kotlinx.coroutines.flow.StateFlow

interface Stopwatch {

    val ticker: StateFlow<String>

    fun start()
    fun pause()
    fun stop()
}