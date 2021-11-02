package com.gmail.rmengelle.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doAfterTextChanged
import com.gmail.rmengelle.activities.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var btn_calculer: Button
//    private lateinit var input_Nb1: EditText
//    private lateinit var input_Nb2: EditText
//    private lateinit var result: TextView

    private lateinit var binding: ComputeActivityBinding
    var number1 = 0
    var number2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnCalculer.visibility = View.INVISIBLE
            btnCalculer.setOnClickListener(this@ComputeActivity)

            field1.doAfterTextChanged {
                if (field1.text.toString().isDigitsOnly() && field1.text.toString().isNotBlank() &&
                    field2.text.toString().isDigitsOnly() && field2.text.toString().isNotBlank()
                ) {
                    btnCalculer.visibility = View.VISIBLE
                    number1 = binding.field1.text.toString().toInt()
                } else {
                    btnCalculer.visibility = View.INVISIBLE
                }
            }
            field2.doAfterTextChanged {
                if (field2.text.toString().isDigitsOnly() && field2.text.toString().isNotBlank() &&
                    field1.text.toString().isDigitsOnly() && field1.text.toString().isNotBlank()
                ) {
                    btnCalculer.visibility = View.VISIBLE
                    number2 = binding.field2.text.toString().toInt()
                } else {
                    btnCalculer.visibility = View.INVISIBLE
                }
            }
        }

        /*INITIALISATION*/
//        btn_calculer = findViewById(R.id.btn_calculer)
//        btn_calculer.visibility = View.INVISIBLE
//        input_Nb1 = findViewById(R.id.field_1)
//        input_Nb2 = findViewById(R.id.field_2)
//        input_Nb2.visibility = View.INVISIBLE
//        result = findViewById(R.id.resultat)

//        input_Nb1.doAfterTextChanged {
//            if (input_Nb1.text.toString().isDigitsOnly() && input_Nb1.text.toString().isNotEmpty()) {
//                input_Nb2.visibility = View.VISIBLE
//            } else {
//                btn_calculer.visibility = View.INVISIBLE
//                Toast.makeText(this, "Veuillez entrer des chiffres INT uniquement", Toast.LENGTH_SHORT).show()
//            }
//        }
//        input_Nb2.doAfterTextChanged {
//            if (input_Nb2.text.toString().isDigitsOnly() && input_Nb2.text.toString().isNotEmpty()) {
//                btn_calculer.visibility = View.VISIBLE
//            } else {
//                btn_calculer.visibility = View.INVISIBLE
//                Toast.makeText(this, "Veuillez entrer des chiffres INT uniquement", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        /*EVENEMENTS*/
//        btn_calculer.setOnClickListener {
//            val intNb1: Int = input_Nb1.text.toString().toInt()
//            val intNb2: Int = input_Nb2.text.toString().toInt()
//            calculer(intNb1, intNb2)
//        }
    }

    override fun onClick(v: View?) {
        calculer(number1, number2)
    }

    private fun calculer(intNb1: Int, intNb2: Int) {
        binding.resultat.text = (intNb1 + intNb2).toString()
    }
}
