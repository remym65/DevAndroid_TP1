package com.gmail.rmengelle.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gmail.rmengelle.neighbors.R
import com.gmail.rmengelle.neighbors.data.NeighborRepository
import com.gmail.rmengelle.neighbors.models.Neighbor

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
    private lateinit var error_phone: TextView
    private lateinit var error_adresse: TextView
    private lateinit var error_apropos: TextView
    var ok1 = false
    var ok2 = false
    var ok3 = false
    var ok4 = false
    var ok5 = false
    var ok6 = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        setHasOptionsMenu(true)

        initInput(view)
        buttonEnregistrer = view.findViewById(R.id.buttonEnregistrer)
        controlInputs()
        buttonEnregistrer.setOnClickListener() {
            if (checkAll()) {
                Toast.makeText(context, "OK ENVOI", Toast.LENGTH_SHORT).show()
                callNeighborCreation()
            } else Toast.makeText(context, "REMPLIR TOUS LES CHAMPS", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    private fun callNeighborCreation() {
        var neighborRepo = NeighborRepository.getInstance()
        var myNeighbor: Neighbor
        var lastNbId = neighborRepo.getNeighbours().last().id
        println("NEIGHBOR CREATION ON ID $lastNbId whit name ${nom_input.text}")
        myNeighbor = Neighbor(
            lastNbId + 1,
            nom_input.text.toString(),
            image_input.text.toString(),
            adresse_input.text.toString(),
            telephone_input.text.toString(),
            apropos_input.text.toString(),
            true,
            website_input.text.toString()
        )
        neighborRepo.createNeighbours(myNeighbor)
    }

    private fun controlInputs() {
        image_input.doAfterTextChanged {
            if (!URLUtil.isValidUrl(image_input.text.toString())) {
                error_img.text = "Lien invalide"
                ok1 = false
            } else {
                error_img.text = "ok"
                ok1 = true
            }
        }
        website_input.doAfterTextChanged {
            if (!URLUtil.isValidUrl(website_input.text.toString())) {
                error_website.text = "Lien invalide"
                ok2 = false
            } else {
                error_website.text = "ok"
                ok2 = true
            }
        }
        nom_input.doAfterTextChanged {
            if (nom_input.text.toString().length < 4) {
                error_nom.text = "Nom invalide (min 4 caract)"
                ok3 = false
            } else {
                error_nom.text = "ok"
                ok3 = true
            }
        }
        adresse_input.doAfterTextChanged {
            if (adresse_input.text.toString().length < 4) {
                error_adresse.text = "Adresse Invalide (min 10 caract)"
                ok4 = false
            } else {
                error_adresse.text = "ok"
                ok4 = true
            }
        }
        apropos_input.doAfterTextChanged {
            if (apropos_input.text.toString().length < 10) {
                error_apropos.text = "A propos Invalide (min 10 caract)"
                ok5 = false
            } else {
                error_apropos.text = "ok"
                ok5 = true
            }
        }
        telephone_input.doAfterTextChanged {
            val numphoneString = telephone_input.text.toString()
            var primernumber = ""
            if (numphoneString.length > 1) {
                primernumber = numphoneString.substring(0, 2)
            }
            if (numphoneString.isDigitsOnly() && numphoneString.length == 10 && (primernumber == "06" || primernumber == "07")) {
                error_phone.text = "ok"
                ok6 = true
            } else {
                error_phone.text = "Telephone invalide"
                ok6 = false
            }
        }
        checkAll()
    }

    private fun checkAll(): Boolean {
        if (ok1 && ok2 && ok3 && ok4 && ok5 && ok6) {
            return true
        } else return false
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
        error_phone = view.findViewById(R.id.errorPhoneText)
        error_apropos = view.findViewById(R.id.errorAproposText)
        error_adresse = view.findViewById(R.id.errorAdresseText)
    }
}
