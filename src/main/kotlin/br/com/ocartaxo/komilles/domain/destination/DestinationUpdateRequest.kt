package br.com.ocartaxo.komilles.domain.destination

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DestinationUpdateRequest(
    val id: Int,
    @SerialName("preco")
    val price: Double? = null,
    @SerialName("foto")
    val photo: String? = null
)
