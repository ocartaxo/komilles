package br.com.ocartaxo.komilles.domain.destination

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DestinationResponse(
    val id: Int,
    @SerialName("nome")
    val name: String,
    @SerialName("foto_caapa")
    val thumbPhoto: String,
    @SerialName("preço")
    val price: Double,
    @SerialName("descricao")
    val description: String,
    @SerialName("foto")
    val photo: String? = null,
    val meta: String? = null
)
