package br.com.ocartaxo.komilles.controller

import br.com.ocartaxo.komilles.domain.destination.*
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/destinos")
class DestinationsController(private val service: DestinationService) {

    @PostMapping
    fun create(
        @RequestBody body: DestinationCreateRequest,
        builder: UriComponentsBuilder
    ): ResponseEntity<DestinationResponse> {
        val destination = service.create(body)
        val uri = builder.buildAndExpand("/api/destinos/${destination.id}").toUri()
        return ResponseEntity.created(uri).body(destination)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Int) = ResponseEntity.ok(service.getById(id))

    @GetMapping
    fun showByName(@RequestParam(name = "name") name: String) = ResponseEntity.ok(service.getByName(name))

    @GetMapping
    fun showAll(@PageableDefault(size=10) pageable: Pageable) = ResponseEntity.ok(service.getAll(pageable))

    @RequestMapping(method = [RequestMethod.PUT, RequestMethod.PATCH])
    fun update(@RequestBody body: DestinationUpdateRequest) = ResponseEntity.ok(service.update(body))

    @DeleteMapping("/{id}")
    fun delete(id: Int): ResponseEntity<Any> {
        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}