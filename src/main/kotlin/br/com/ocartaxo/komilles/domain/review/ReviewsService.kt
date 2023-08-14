package br.com.ocartaxo.komilles.domain.review

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReviewsService(
    private val repository: ReviewsRepository,
    private val mapper: ReviewMapper

) {

    fun create(request: ReviewRequest): ReviewResponse {
        val s = mapper.toEntity(request)
        return mapper.toDTO(repository.save(s))
    }

    fun show(id: Int): ReviewResponse = repository.findById(id)
        .orElseThrow { RuntimeException("Depoimento de id `$id` não encontrado!") }.run { mapper.toDTO(this) }

    fun showAll(pageable: Pageable) = repository.findAll(pageable).map(mapper::toDTO)
    fun update(request: ReviewUpdateRequest): ReviewResponse {
        val review = repository.findById(request.id)
            .orElseThrow{ RuntimeException("Depoimento de id `${request.id}` não encontrado!") }

        review.update(request)

        return mapper.toDTO(review)

    }

    fun deleteBy(id: Int) = repository.deleteById(id)

}
