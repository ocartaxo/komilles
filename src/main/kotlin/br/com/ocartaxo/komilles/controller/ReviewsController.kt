package br.com.ocartaxo.komilles.controller

import br.com.ocartaxo.komilles.domain.review.ReviewCreateRequest
import br.com.ocartaxo.komilles.domain.review.ReviewResponse
import br.com.ocartaxo.komilles.domain.review.ReviewUpdateRequest
import br.com.ocartaxo.komilles.domain.review.ReviewsService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/depoimentos")
class ReviewsController(
    private val service: ReviewsService
) {

    @PostMapping
    fun create(
        @RequestBody @Valid request: ReviewCreateRequest,
        builder: UriComponentsBuilder
    ): ResponseEntity<ReviewResponse> {
        val review = service.create(request)
        val uri = builder.buildAndExpand("/api/depoimentos-home/${review.id}").toUri()

        return ResponseEntity.created(uri).body(review)
    }

    @GetMapping
    fun list(@PageableDefault(size = 10) pageable: Pageable) = ResponseEntity.ok(service.showAll(pageable))

    @GetMapping("/{id}")
    fun show(@PathVariable id: Int): ResponseEntity<ReviewResponse> = ResponseEntity.ok(service.show(id))

    @RequestMapping(method = [RequestMethod.PUT, RequestMethod.PATCH])
    fun update(@RequestBody request: ReviewUpdateRequest) = ResponseEntity.ok(service.update(request))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteBy(id))
}