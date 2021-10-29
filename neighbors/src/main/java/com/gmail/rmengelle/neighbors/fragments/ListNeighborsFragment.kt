package com.gmail.rmengelle.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.rmengelle.neighbors.R
import com.gmail.rmengelle.neighbors.adapters.ListNeighborHandler
import com.gmail.rmengelle.neighbors.adapters.ListNeighborsAdapter
import com.gmail.rmengelle.neighbors.data.NeighborRepository
import com.gmail.rmengelle.neighbors.models.Neighbor

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshList()
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Voulez-vous vraiment supprimer?")
            builder.apply {
                setPositiveButton("oui") { dialog, _ ->
                    NeighborRepository.getInstance().delateNeighbours(neighbor)
                    refreshList()
                    dialog.dismiss()
                }
                setNegativeButton("non") { dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.create().show()
        }
    }

    private fun refreshList() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
