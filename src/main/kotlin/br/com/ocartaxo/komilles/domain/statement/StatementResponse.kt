package br.com.ocartaxo.komilles.domain.statement

import com.fasterxml.jackson.annotation.JsonProperty

data class StatementResponse(
    val id: Int,
    @JsonProperty("nome_usuario")
    val username: String,
    @JsonProperty("comentário")
    val comment: String,
    @JsonProperty("foto")
    val photo: String
)
