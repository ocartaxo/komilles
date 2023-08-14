package br.com.ocartaxo.komilles.domain.review

import jakarta.validation.constraints.NotBlank
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewRequest(
    @NotBlank
    @SerialName("usuario")
    val username: String,
    @NotBlank
    @SerialName("depoimento")
    val review: String,
    @SerialName("foto")
    val photo: String
)
