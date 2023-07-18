package br.com.ocartaxo.komilles.domain.statement

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class StatementsService(private val repository: StatementsRepository) {

    fun create(request: StatementRequest): StatementResponse {
        val s = request.toEntity()
        return repository.save(s).toDTO()
    }

    fun show(id: Int): StatementResponse = repository.findById(id)
        .orElseThrow { RuntimeException("Depoimento de id `$id` não encontrado!") }.toDTO()

    fun showAll(pageable: Pageable) = repository.findAll(pageable).map(Statement::toDTO)
    fun update(request: StatementUpdateRequest): StatementResponse {
        val statement = repository.findById(request.id)
            .orElseThrow{ RuntimeException("Depoimento de id `${request.id}` não encontrado!") }

        statement.update(request)

        return statement.toDTO()

    }

    fun deleteBy(id: Int) = repository.deleteById(id)

}

private fun Statement.update(request: StatementUpdateRequest) {
    this.statement = request.comment ?: this.statement
    this.photo = request.photo ?: this.photo
}
private fun StatementRequest.toEntity()  = Statement(
    username = this.username,
    photo = this.photo,
    statement = this.comment
)

private fun Statement.toDTO() = StatementResponse(
    id = this.id!!,
    username = this.username,
    photo = this.photo,
    comment = this.statement
)