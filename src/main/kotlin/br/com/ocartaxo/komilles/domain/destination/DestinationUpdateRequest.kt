package br.com.ocartaxo.komilles.domain.destination

data class DestinationUpdateRequest(
    val id: Int,
    val price: Double,
    val photo: String
)
