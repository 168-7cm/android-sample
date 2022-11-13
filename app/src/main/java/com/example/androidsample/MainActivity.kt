package com.example.androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import com.example.androidsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf("胡椒", "コリアンダー", "生姜", "ニンニク")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_checked,
            data
        )

        val listView = binding.listView
        listView.adapter = adapter

        listView.setOnItemClickListener { av, view, position, id ->
            val msg = mutableListOf<CharSequence>()

            listView.forEach {
                val check = it as CheckedTextView
                if (check.isChecked) msg.add(check.text)
            }

            Toast.makeText(
                this@MainActivity,
                "選択したのは${msg.joinToString()}です",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}