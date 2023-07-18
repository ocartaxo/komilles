package br.com.ocartaxo.komilles.domain.statement

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
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
