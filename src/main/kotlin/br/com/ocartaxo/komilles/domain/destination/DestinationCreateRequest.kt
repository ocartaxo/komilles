package br.com.ocartaxo.komilles.domain.destination

import com.fasterxml.jackson.annotation.JsonProperty

data class DestinationCreateRequest(
    @JsonProperty("nome")
    val name: String,
    @JsonProperty("foto1")
    val thumbnailPhoto: String,
    @JsonProperty("foto2")
    val optionalPhoto: String? = null,
    val price: Double,
    @JsonProperty("descricao")
    val description: String? = null,

    val meta: String? = null
)
