package com.gmail.rmengelle.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var comptTextView: TextView
    private lateinit var btnCompute: Button

    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // on initialise bouton créé sur son id
        clickButton = findViewById(R.id.btn_click_me)
        // init text view
        comptTextView = findViewById(R.id.view_click)
        // init button compute
        btnCompute = findViewById(R.id.btn_compute)

        // on recuperer l'event click du premier button (click me)
        clickButton.setOnClickListener {
            nbClick++
            displayNbClick(nbClick)
        }

        // on recupere l'event click de compute button
        btnCompute.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayNbClick(nbClick: Int) {
        if (nbClick < 1) {
            comptTextView.clearComposingText()
        } else if (nbClick <6 - 1) {
            comptTextView.text = "Vous avez clicqué $nbClick fois"
        } else {
            clickButton.isEnabled = false
            comptTextView.text = "Vous avez clicqué $nbClick fois"
        }
    }
}
