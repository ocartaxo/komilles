package br.com.ocartaxo.komilles.domain.statement

import org.springframework.data.jpa.repository.JpaRepository

interface StatementsRepository: JpaRepository<Statement, Int> {
}