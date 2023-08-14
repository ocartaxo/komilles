package br.com.ocartaxo.komilles.domain.review

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    val id: Int,
    @JsonProperty("nome_usuario")
    val username: String,
    @JsonProperty("depoimento")
    val review: String,
    @JsonProperty("foto")
    val photo: String
)
