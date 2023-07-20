package br.com.ocartaxo.komilles.domain.statement

import com.fasterxml.jackson.annotation.JsonProperty
import com.nimbusds.jose.shaded.gson.annotations.SerializedName
import jakarta.validation.constraints.NotBlank

data class StatementRequest(
    @NotBlank
    @JsonProperty("usuario")
    @SerializedName("usuario")
    val username: String,
    @NotBlank
    @JsonProperty("depoimento")
    @SerializedName("depoimento")
    val comment: String,
    @JsonProperty("foto")
    @SerializedName("foto")
    val photo: String
)
