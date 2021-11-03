package com.gmail.rmengelle.neighbors.data

import com.gmail.rmengelle.neighbors.data.service.DummyNeighborApiService
import com.gmail.rmengelle.neighbors.data.service.NeighborApiService
import com.gmail.rmengelle.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun delateNeighbours(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun createNeighbours(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
