package com.gmail.rmengelle.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class ComputeActivity : AppCompatActivity() {
    private lateinit var btn_calculer: Button
    private lateinit var input_Nb1: EditText
    private lateinit var input_Nb2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        /*INITIALISATION*/
        btn_calculer = findViewById(R.id.btn_calculer)
        btn_calculer.visibility = View.INVISIBLE
        input_Nb1 = findViewById(R.id.field_1)
        input_Nb2 = findViewById(R.id.field_2)
        input_Nb2.visibility = View.INVISIBLE
        result = findViewById(R.id.resultat)

        input_Nb1.doAfterTextChanged {
            input_Nb2.visibility = View.VISIBLE
        }
        input_Nb2.doAfterTextChanged {
            btn_calculer.visibility = View.VISIBLE
        }

        /*EVENEMENTS*/
        btn_calculer.setOnClickListener {
            val intNb1: Int = input_Nb1.text.toString().toInt()
            val intNb2: Int = input_Nb2.text.toString().toInt()
            calculer(intNb1,intNb2)
        }
    }

    private fun calculer(intNb1: Int, intNb2: Int) {
        result.text = (intNb1+intNb2).toString()
    }
}
