package br.com.ocartaxo.komilles.domain.destination

import com.fasterxml.jackson.annotation.JsonProperty

data class DestinationUpdateRequest(
    val id: Int,
    @JsonProperty("preco")
    val price: Double ? = null,
    @JsonProperty("foto1")
    val thumbnailPhoto: String ? = null,
    @JsonProperty("foto2")
    val photo: String ? = null,
    @JsonProperty("meta")
    val meta: String ? = null,
    @JsonProperty("descricao")
    val description: String? = null
)
