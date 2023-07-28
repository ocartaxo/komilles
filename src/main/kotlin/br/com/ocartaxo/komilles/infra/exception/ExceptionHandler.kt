package br.com.ocartaxo.komilles.infra.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleRuntimeException(ex: Exception, request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity.internalServerError().body(object {
            val status = HttpStatus.INTERNAL_SERVER_ERROR
            val error = HttpStatus.INTERNAL_SERVER_ERROR.name
            val message = ex.localizedMessage
            val timestamp = LocalDateTime.now()
            val path = request.servletPath
        })
    }

    @ExceptionHandler(DestinationNotFoundException::class)
    fun handleDestinationError(
        ex: DestinationNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(object {
            val status = HttpStatus.NOT_FOUND
            val error = HttpStatus.NOT_FOUND.name
            val message = ex.message
            val timestamp = LocalDateTime.now()
            val path = request.servletPath

        })
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(object {
            val status = HttpStatus.BAD_REQUEST
            val error = HttpStatus.BAD_REQUEST.name
            val errorMessage = ex.bindingResult.fieldErrors.associate { e -> e.field to e.defaultMessage }.toString()
            val timestamp = LocalDateTime.now()
            val path = request.servletPath

        })
    }



}