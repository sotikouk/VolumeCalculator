package com.sotkou.volumecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.times

class SphereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sphere)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result: TextView = findViewById(R.id.sphereResult)
        val button: Button = findViewById(R.id.shereVolume)
        val editText: EditText = findViewById(R.id.editTextSphere)

        button.setOnClickListener {
            var radius = editText.text.toString()
            var rd = radius.toDouble()

            // V = (4/3)*Πι*r*r*r
            var volume = (4/3)*Math.PI*rd*rd*rd
            result.text = "V = $volume m^3"
        }
    }
}