package br.com.ocartaxo.komilles.infra.exception

data class DestinationNotFoundException(
    val attr: String
): RuntimeException("Nenhum destino com a informação `$attr` foi encontrado!")