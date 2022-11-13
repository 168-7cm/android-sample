package com.example.androidsample

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
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
            R.layout.simple_list_item_checked,
            data
        )

        val listView = binding.listView
        listView.adapter = adapter

        listView.setMultiChoiceModeListener(object: AbsListView.MultiChoiceModeListener {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return true
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return true
            }

            override fun onItemCheckedStateChanged(p0: ActionMode?, p1: Int, p2: Long, p3: Boolean) {}

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                return true
            }

            override fun onDestroyActionMode(p0: ActionMode?) {
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
        })
    }
}