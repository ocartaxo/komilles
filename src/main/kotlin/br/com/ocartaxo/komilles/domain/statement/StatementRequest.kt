package br.com.ocartaxo.komilles.domain.statement

data class StatementRequest(
    val username: String,
    val comment: String,
    val photo: String
)
