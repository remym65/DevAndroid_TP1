package com.gmail.rmengelle.neighbors.adapters

import com.gmail.rmengelle.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
}
