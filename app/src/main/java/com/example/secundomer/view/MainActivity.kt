package com.example.secundomer.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.secundomer.databinding.ActivityMainBinding
import com.example.secundomer.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
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
                Log.d("TAG", "start clicked")
                viewModel.onStartClicked()
            }
            buttonPause.setOnClickListener {
                Log.d("TAG", "pause clicked")
                viewModel.onPauseClicked()
            }
            buttonStop.setOnClickListener {
                Log.d("TAG", "stop clicked")
                viewModel.onStopClicked()
            }
        }
    }
}