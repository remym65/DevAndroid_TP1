package com.gmail.rmengelle.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadImage("https://goo.gl/gEgYUd")
    }

//    pour charger l'image depuis une page internet et la resize
    fun loadImage(url: String) {
        Picasso.get()
            .load(url)
            .resize(400, 400)
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }

    // implementation de la fonction onClick
    override fun onClick(view: View?) {
        val link = "https://www.nicepng.com/png/detail/397-3972078_poster-smelly-cat-smelly-cat-friends.png"
        loadImage(link)
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }
}
