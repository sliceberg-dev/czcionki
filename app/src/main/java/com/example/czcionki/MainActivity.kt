package com.example.czcionki

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.SeekBar
import android.util.TypedValue
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val quotes = arrayOf("Dzień Dobry","Good Morning", "Buenos dias")

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val seekBar = findViewById<SeekBar>(R.id.rozmiar)
        val text = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.button)
        text.text = quotes[index]
        button.setOnClickListener {
            index = (index + 1) % quotes.size

            text.text = quotes[index]
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {





                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress.toFloat())
            }

            override fun onStartTrackingTouch(sb: SeekBar?) {

            }

            override fun onStopTrackingTouch(sb: SeekBar?) {

            }
        })


    }
}