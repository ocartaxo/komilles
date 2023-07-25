package br.com.ocartaxo.komilles.domain.review

import jakarta.persistence.*

@Entity
@Table(name = "analises")
data class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name="usuario")
    val username: String,
    @Column(name = "foto")
    var photo: String,
    @Column(name="depoimento")
    var review: String
)
