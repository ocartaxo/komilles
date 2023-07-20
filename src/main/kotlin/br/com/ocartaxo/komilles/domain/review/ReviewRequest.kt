package br.com.ocartaxo.komilles.domain.review

import com.fasterxml.jackson.annotation.JsonProperty
import com.nimbusds.jose.shaded.gson.annotations.SerializedName
import jakarta.validation.constraints.NotBlank

data class ReviewRequest(
    @NotBlank
    @JsonProperty("usuario")
    @SerializedName("usuario")
    val username: String,
    @NotBlank
    @JsonProperty("analise")
    @SerializedName("analise")
    val comment: String,
    @JsonProperty("foto")
    @SerializedName("foto")
    val photo: String
)
