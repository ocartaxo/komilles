package br.com.ocartaxo.komilles.domain.review

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReviewsService(private val repository: ReviewsRepository) {

    fun create(request: ReviewRequest): ReviewResponse {
        val s = request.toEntity()
        return repository.save(s).toDTO()
    }

    fun show(id: Int): ReviewResponse = repository.findById(id)
        .orElseThrow { RuntimeException("Depoimento de id `$id` não encontrado!") }.toDTO()

    fun showAll(pageable: Pageable) = repository.findAll(pageable).map(Review::toDTO)
    fun update(request: ReviewUpdateRequest): ReviewResponse {
        val statement = repository.findById(request.id)
            .orElseThrow{ RuntimeException("Depoimento de id `${request.id}` não encontrado!") }

        statement.update(request)

        return statement.toDTO()

    }

    fun deleteBy(id: Int) = repository.deleteById(id)

}

private fun Review.update(request: ReviewUpdateRequest) {
    this.statement = request.comment ?: this.statement
    this.photo = request.photo ?: this.photo
}
private fun ReviewRequest.toEntity()  = Review(
    username = this.username,
    photo = this.photo,
    statement = this.comment
)

private fun Review.toDTO() = ReviewResponse(
    id = this.id!!,
    username = this.username,
    photo = this.photo,
    comment = this.statement
)