package com.example.secundomer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.secundomer.model.Stopwatch

class MainVieModelFactory(private val stopwatch: Stopwatch) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(Stopwatch::class.java)
            .newInstance(stopwatch)
    }
}