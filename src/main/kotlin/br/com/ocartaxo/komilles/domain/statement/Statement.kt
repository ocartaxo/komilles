package br.com.ocartaxo.komilles.domain.statement

import jakarta.persistence.*

@Entity
@Table(name = "depoimentos")
data class Statement(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name="usuario")
    val username: String,
    @Column(name = "foto")
    var photo: String,
    @Column(name="depoimento")
    var statement: String
)
