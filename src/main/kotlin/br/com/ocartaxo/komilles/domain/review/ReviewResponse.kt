package br.com.ocartaxo.komilles.domain.review

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    val id: Int,
    @SerialName("usuario")
    val username: String,
    @SerialName("depoimento")
    val review: String,
    @SerialName("foto")
    val photo: String
)
