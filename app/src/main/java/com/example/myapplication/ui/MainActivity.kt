package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.common.systems.network.SocketManager
import com.example.myapplication.ui.compose.main.HomeWorkApp
import dagger.hilt.android.AndroidEntryPoint

private const val SERVER_ADDRESS = "challenge.ciliz.com"
private const val SERVER_PORT = 2222

@AndroidEntryPoint
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