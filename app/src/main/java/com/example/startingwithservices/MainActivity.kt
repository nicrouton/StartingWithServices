package com.example.startingwithservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeEditText = findViewById<EditText>(R.id.editTextText)

        findViewById<Button>(R.id.button).setOnClickListener{
            startService(Intent(this, MyService::class.java).putExtra("key",timeEditText.text.toString().toInt()))
        }

    }
}