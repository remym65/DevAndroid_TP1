package com.gmail.rmengelle.neighbors.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gmail.rmengelle.neighbors.R

class AddNeighbourFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonEnregistrer: Button
    private lateinit var nom_input: EditText
    private lateinit var image_input: EditText
    private lateinit var adresse_input: EditText
    private lateinit var telephone_input: EditText
    private lateinit var website_input: EditText
    private lateinit var apropos_input: EditText
    private lateinit var error_img: TextView
    private lateinit var error_website: TextView
    private lateinit var error_nom: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        setHasOptionsMenu(true)

        initInput(view)

        buttonEnregistrer = view.findViewById(R.id.buttonEnregistrer)
        buttonEnregistrer.isEnabled = controlInputs()
        buttonEnregistrer.setOnClickListener() {
            testIfNotEmpty()
        }
        return view
    }

    private fun controlInputs(): Boolean {
        var ok = false // test if all ok
        image_input.doAfterTextChanged {
            if (!URLUtil.isValidUrl(image_input.text.toString())) {
                error_img.text = "Lien invalide"
                ok = false
            } else {
                ok = true
            }
        }
        website_input.doAfterTextChanged {
            if (!URLUtil.isValidUrl(website_input.text.toString())) {
                error_website.text = "Lien invalide"
                ok = false
            } else {
                error_website.text = ""
                ok = true
            }
        }
        nom_input.doAfterTextChanged {
            if (nom_input.text.toString().length < 4) {
                error_nom.text = "Nom invalide (trop court)"
                ok = false
            } else {
                error_nom.text = ""
                ok = true
            }
        }
        return ok
    }

    private fun initInput(view: View) {
        nom_input = view.findViewById<EditText>(R.id.nom_input)
        image_input = view.findViewById<EditText>(R.id.image_input)
        adresse_input = view.findViewById<EditText>(R.id.adresse_input)
        telephone_input = view.findViewById<EditText>(R.id.telephone_input)
        website_input = view.findViewById<EditText>(R.id.website_input)
        apropos_input = view.findViewById<EditText>(R.id.apropos_input)
        error_img = view.findViewById(R.id.errorImgText)
        error_website = view.findViewById(R.id.errorWebsiteText)
        error_nom = view.findViewById(R.id.errorNomText)
    }

    //    private fun testIsEmpty(nomInput: EditText, imageInput: EditText, adresseInput: EditText, telephoneInput: EditText, websiteInput: EditText, aproposInput: EditText) {
    private fun testIfNotEmpty(): Boolean {
        if (TextUtils.isEmpty(nom_input.text.toString()) ||
            TextUtils.isEmpty(image_input.text.toString()) ||
            TextUtils.isEmpty(adresse_input.text.toString()) ||
            TextUtils.isEmpty(telephone_input.text.toString()) ||
            TextUtils.isEmpty(website_input.text.toString()) ||
            TextUtils.isEmpty(apropos_input.text.toString())
        ) {
            Toast.makeText(context, "Tous les champs doivent etre renseignés", Toast.LENGTH_SHORT)
                .show()
            return false
        } else return true
    }
}
