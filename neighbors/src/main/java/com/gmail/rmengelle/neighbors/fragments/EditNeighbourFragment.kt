package com.gmail.rmengelle.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.rmengelle.neighbors.R

class EditNeighbourFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_neighbor_fragment, container, false)
        setHasOptionsMenu(true)
        return view
    }
}
