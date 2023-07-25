package br.com.ocartaxo.komilles.domain.destination

import com.fasterxml.jackson.annotation.JsonProperty

data class DestinationResponse(
    val id: Int,
    @JsonProperty("nome")
    val name: String,
    @JsonProperty("foto")
    val photo: String,
    @JsonProperty("preço")
    val price: Double
)
