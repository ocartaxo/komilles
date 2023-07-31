package br.com.ocartaxo.komilles.domain.destination

import com.fasterxml.jackson.annotation.JsonProperty

data class DestinationUpdateRequest(
    val id: Int,
    @JsonProperty("preco")
    val price: Double,
    @JsonProperty("foto1")
    val thumbnailPhoto: String,
    @JsonProperty("foto2")
    val photo: String,
    @JsonProperty("meta")
    val meta: String,
    @JsonProperty("descricao")
    val description: String? = null
)
