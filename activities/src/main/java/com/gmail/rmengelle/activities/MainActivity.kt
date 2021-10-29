package com.gmail.rmengelle.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gmail.rmengelle.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClickMe.setOnClickListener(this)
        binding.btnCompute.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_click_me -> {
                nbClick++
                binding.viewClick.text = getString(R.string.you_click, nbClick)
                binding.btnClickMe.isEnabled = nbClick <= 4
            }
            R.id.btn_compute -> {
                val intent = Intent(baseContext, ComputeActivity::class.java)
                startActivity(intent)
            }
        }
    }

//    private fun displayNbClick(nbClick: Int) {
//        if (nbClick < 1) {
//            comptTextView.clearComposingText()
//        } else if (nbClick <6 - 1) {
//            comptTextView.text = "Vous avez clicqué $nbClick fois"
//        } else {
//            clickButton.isEnabled = false
//            comptTextView.text = "Vous avez clicqué $nbClick fois"
//        }
//    }
}
