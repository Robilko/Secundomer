package com.example.secundomer.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.secundomer.databinding.ActivityMainBinding
import com.example.secundomer.di.StopwatchModule
import com.example.secundomer.viewmodel.MainVieModelFactory
import com.example.secundomer.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /** Ленивая инициализация viewmodel с использованием ViewModelProvider и фабрики, для того чтобы наша вьюмодель жила пока наша активити не закроется окончательно */
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            MainVieModelFactory(StopwatchModule().getStopwatch())
        )[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.ticker.collect {
                    binding.textTime.text = it
                }
            }
        }

    }

    private fun setListeners() {
        with(binding) {
            buttonStart.setOnClickListener {
                viewModel.onStartClicked()
            }
            buttonPause.setOnClickListener {
                viewModel.onPauseClicked()
            }
            buttonStop.setOnClickListener {
                viewModel.onStopClicked()
            }
        }
    }
}