package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.SocketManager
import com.example.myapplication.ui.compose.HomeWorkApp

private const val SERVER_ADDRESS = "challenge.ciliz.com"
private const val SERVER_PORT = 2222

class MainActivity : AppCompatActivity() {

    private val socketManager = SocketManager(SERVER_ADDRESS, SERVER_PORT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeWorkApp()
        }
        /*
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.button1.setOnClickListener {
            binding.button1.text = "Clicked"
        }

         */
    }
}