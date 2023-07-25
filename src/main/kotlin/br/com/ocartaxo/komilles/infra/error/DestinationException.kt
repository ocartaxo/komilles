package br.com.ocartaxo.komilles.infra.error

data class DestinationException(
    val msg: String? = null
): RuntimeException(msg)
