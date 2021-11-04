package com.gmail.rmengelle.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.rmengelle.neighbors.NavigationListener
import com.gmail.rmengelle.neighbors.R
import com.gmail.rmengelle.neighbors.data.NeighborRepository
import com.gmail.rmengelle.neighbors.models.Neighbor

class EditNeighbourFragment : Fragment() {
    private lateinit var textEditNei: TextView
    private lateinit var buttonBack: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_neighbor_fragment, container, false)
        setHasOptionsMenu(true)
        buttonBack = view.findViewById(R.id.backButton)
        textEditNei = view.findViewById(R.id.editTextCreatedNei)
        lastCreatedNei()
        buttonBack.setOnClickListener() {
            changeViewFragment(inflater, container, ListNeighborsFragment(), R.string.listNbgTitle)
        }
        return view
    }

    private fun changeViewFragment(
        inflater: LayoutInflater,
        container: ViewGroup?,
        fragment: Fragment,
        title: Int
    ) {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        (activity as? NavigationListener)?.let {
            it.updateTitle(title)
            it.showFragment(fragment)
        }
    }
    private fun lastCreatedNei() {
        var neighborRepo = NeighborRepository.getInstance()
        var myNeighbor: Neighbor
        var lastNbId = neighborRepo.getNeighbours().last().id
        myNeighbor = neighborRepo.getNeighbours()[lastNbId.toInt() - 1]
        textEditNei.text = "Nouveau voisin: id: ${myNeighbor.id}, name: ${myNeighbor.name}"
    }
}
