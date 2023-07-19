package br.com.ocartaxo.komilles.infra.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<Any> {
        return ResponseEntity.internalServerError().body(object {
            val message = "Error não identificado!"
            val errMsg = ex.localizedMessage
        })
    }

}