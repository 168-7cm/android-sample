package com.example.androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidsample.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ratingBar.setOnRatingBarChangeListener { _, rate, _ ->
            Toast.makeText(
                this@MainActivity,
                "現在の評価は${rate}です",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}