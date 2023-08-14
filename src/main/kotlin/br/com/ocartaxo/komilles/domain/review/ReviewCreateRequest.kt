package br.com.ocartaxo.komilles.domain.review

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import kotlinx.serialization.Serializable

@Serializable
data class ReviewRequest(
    @NotBlank
    @JsonProperty("usuario")
    val username: String,
    @NotBlank
    @JsonProperty("depoimento")
    val review: String,
    @JsonProperty("foto")
    val photo: String
)
