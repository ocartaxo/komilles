package br.com.ocartaxo.komilles.domain.destination

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DestinationResponse(
    val id: Int,
    @SerialName("nome")
    val name: String,
    @SerialName("foto")
    val photo: String,
    @SerialName("preco")
    val price: Double
)
