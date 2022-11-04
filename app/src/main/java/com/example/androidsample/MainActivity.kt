package com.example.androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androidsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            binding.webView.loadUrl(
                when(it.id) {
                    binding.homeButton.id -> "https://wings.msn.to/"
                    binding.envButton.id -> "https://wings.msn.to/index.php/-/B-08/"
                    binding.webView.id -> "https://www.shuwasystem.co.jp/smp/"
                    else -> "https://wings.msn.to/"
                }
            )
        }

        arrayListOf(
            binding.homeButton,
            binding.envButton,
            binding.infoButton
        ).forEach { it.setOnClickListener(listener) }
    }
}