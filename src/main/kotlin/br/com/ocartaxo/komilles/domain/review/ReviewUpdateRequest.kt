package br.com.ocartaxo.komilles.domain.review

import com.fasterxml.jackson.annotation.JsonProperty

data class ReviewUpdateRequest(
    val id: Int,
    @JsonProperty("analise")
    val comment: String? = null,
    @JsonProperty("foto")
    val photo: String? = null
)
