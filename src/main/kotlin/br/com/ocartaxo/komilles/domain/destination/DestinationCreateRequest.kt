package br.com.ocartaxo.komilles.domain.destination

data class DestinationCreateRequest(
    val name: String,
    val photo: String,
    val price: Double
)
