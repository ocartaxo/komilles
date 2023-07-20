package br.com.ocartaxo.komilles.domain.review

import com.fasterxml.jackson.annotation.JsonProperty

data class ReviewResponse(
    val id: Int,
    @JsonProperty("nome_usuario")
    val username: String,
    @JsonProperty("analise")
    val review: String,
    @JsonProperty("foto")
    val photo: String
)
