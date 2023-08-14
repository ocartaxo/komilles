package br.com.ocartaxo.komilles.domain.review

import org.springframework.stereotype.Component

@Component
object ReviewMapper {
    fun toEntity(request: ReviewRequest) = Review(
        username = request.username,
        photo = request.photo,
        review = request.review
    )

    fun toDTO(entity: Review) = ReviewResponse(
        id = entity.id!!,
        username = entity.username,
        photo = entity.photo,
        review = entity.review
    )
}