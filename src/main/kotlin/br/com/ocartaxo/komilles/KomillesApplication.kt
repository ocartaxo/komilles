package br.com.ocartaxo.komilles

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KomillesApplication

fun main(args: Array<String>) {
	runApplication<KomillesApplication>(*args)
}
