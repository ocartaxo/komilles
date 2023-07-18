package br.com.ocartaxo.komilles.controller

import br.com.ocartaxo.komilles.domain.statement.StatementRequest
import br.com.ocartaxo.komilles.domain.statement.StatementResponse
import br.com.ocartaxo.komilles.domain.statement.StatementUpdateRequest
import br.com.ocartaxo.komilles.domain.statement.StatementsService
import br.com.ocartaxo.komilles.statement.*
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/depoimentos")
class StatementsController(private val service: StatementsService
) {

    @PostMapping
    fun create(
        @RequestBody @Valid request: StatementRequest,
        builder: UriComponentsBuilder
    ): ResponseEntity<StatementResponse> {
        val statement = service.create(request)
        val uri = builder.buildAndExpand("/api/depoimentos-home/${statement.id}").toUri()

        return ResponseEntity.created(uri).body(statement)
    }

    @GetMapping
    fun list(@PageableDefault(size=10) pageable: Pageable) = ResponseEntity.ok(service.showAll(pageable))

    @GetMapping("/{id}")
    fun show(@PathVariable id: Int): ResponseEntity<StatementResponse> = ResponseEntity.ok(service.show(id))

    @RequestMapping(method = [RequestMethod.PUT, RequestMethod.PATCH])
    fun update(@RequestBody request: StatementUpdateRequest) = ResponseEntity.ok(service.update(request))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = ResponseEntity.status(204).body(service.deleteBy(id))
}