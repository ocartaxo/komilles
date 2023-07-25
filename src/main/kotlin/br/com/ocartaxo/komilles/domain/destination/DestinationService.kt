package br.com.ocartaxo.komilles.domain.destination

import br.com.ocartaxo.komilles.infra.error.DestinationException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DestinationService(private val repository: DestinationRepository) {


    fun create(body: DestinationCreateRequest): DestinationResponse {

        val entity = body.toEntity()

        repository.save(entity)

        return entity.toDTO()
    }

    fun get(id: Int) = repository.findById(id)
        .orElseThrow { DestinationException("Nenhum destino de $id foi encontrado!") }
        .toDTO()

    fun getByName(destinationName: String) = repository.findDestinationByName(destinationName)
        .orElseThrow{ DestinationException("Nenhum destino foi encontrado") }

    fun getAll(pageable: Pageable) = repository.findAll(pageable).map(Destination::toDTO)
    fun update(body: DestinationUpdateRequest): DestinationResponse {
        val destination = repository.findById(body.id).orElseThrow { DestinationException("Nenhum destino encontrado!") }

        destination.update(body)

        return destination.toDTO()
    }

    fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}

fun Destination.update(body: DestinationUpdateRequest) {
    this.photo = body.photo
    this.price = body.price
}

private fun Destination.toDTO() = DestinationResponse(
    id = this.id!!,
    name = this.name,
    photo = this.photo,
    price = this.price
)

private fun DestinationCreateRequest.toEntity() = Destination(
    name = this.name,
    photo = this.photo,
    price = this.price
)
