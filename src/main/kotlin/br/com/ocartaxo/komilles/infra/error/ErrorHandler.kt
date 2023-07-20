package br.com.ocartaxo.komilles.infra.error

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException, request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity.internalServerError().body(object {
            val message = "Error não identificado!"
            val error = ex.localizedMessage
            val timestamp = LocalDateTime.now()
            val statusCode = HttpStatus.INTERNAL_SERVER_ERROR
            val path = request.requestURI
        })
    }

}