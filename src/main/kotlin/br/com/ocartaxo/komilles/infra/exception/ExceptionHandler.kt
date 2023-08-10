package br.com.ocartaxo.komilles.infra.exception

import com.aallam.openai.api.exception.RateLimitException
import jakarta.servlet.http.HttpServletRequest
import kotlinx.serialization.Serializable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleRuntimeException(ex: Exception, request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ErrorResponse(
            path = request.servletPath,
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = ex.message

        ))
    }

    @ExceptionHandler(DestinationNotFoundException::class)
    fun handleDestinationError(
        ex: DestinationNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ErrorResponse(
            path = request.servletPath,
            status = HttpStatus.NOT_FOUND,
            error = HttpStatus.NOT_FOUND.name,
            message = ex.message

        ))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ErrorResponse(
            path = request.servletPath,
            status = HttpStatus.BAD_REQUEST,
            error = HttpStatus.BAD_REQUEST.name,
            message = ex.bindingResult.fieldErrors.associate { e -> e.field to e.defaultMessage }.toString(),

        ))
    }

    @ExceptionHandler
    fun handleOpenAIError(
        ex: RateLimitException,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.ok().build()
    }

    @Serializable
    private data class ErrorResponse(
        val status: HttpStatus,
        val message: String?,
        val error: String,
        val path: String,
        val timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
    )

}