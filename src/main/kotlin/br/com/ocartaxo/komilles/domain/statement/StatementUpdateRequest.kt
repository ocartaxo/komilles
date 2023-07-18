package br.com.ocartaxo.komilles.domain.statement

import com.fasterxml.jackson.annotation.JsonProperty

data class StatementUpdateRequest(
    val id: Int,
    @JsonProperty("comentário")
    val comment: String?,
    @JsonProperty("foto")
    val photo: String?
)
