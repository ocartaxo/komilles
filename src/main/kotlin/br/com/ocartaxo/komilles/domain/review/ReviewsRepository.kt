package br.com.ocartaxo.komilles.domain.review

import org.springframework.data.jpa.repository.JpaRepository

interface ReviewsRepository: JpaRepository<Review, Int> {
}