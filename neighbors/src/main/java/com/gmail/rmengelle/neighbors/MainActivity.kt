package com.gmail.rmengelle.neighbors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.gmail.rmengelle.neighbors.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(), NavigationListener {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        updateTitle(R.string.listNbgTitle)
        showFragment(ListNeighborsFragment())
//        changeFragment(ListNeighborsFragment())
    }

    override fun updateTitle(title: Int) {
        toolbar.setTitle(title)
    }

    //    private fun changeFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container, fragment)
//            addToBackStack(null)
//        }.commit()
//    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }
}
