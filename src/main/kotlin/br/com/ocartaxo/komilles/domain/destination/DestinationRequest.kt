package br.com.ocartaxo.komilles.domain.destination

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DestinationRequest(
    @NotBlank
    @SerialName("destino")
    val name: String,
    @NotBlank
    @SerialName("foto")
    val photo: String,
    @NotEmpty
    @SerialName("preco")
    val price: Double
)
