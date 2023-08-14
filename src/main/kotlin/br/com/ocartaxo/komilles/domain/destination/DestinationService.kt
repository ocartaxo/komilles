package br.com.ocartaxo.komilles.domain.destination

import br.com.ocartaxo.komilles.infra.exception.DestinationNotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DestinationService(
    private val repository: DestinationRepository,
    private val mapper: DestinationMapper
) {


    fun create(body: DestinationRequest): DestinationResponse {

        val entity = mapper.toEntity(body)

        repository.save(entity)

        return mapper.toDTO(entity)
    }

    fun getById(id: Int): DestinationResponse = repository.findById(id)
        .orElseThrow { DestinationNotFoundException("${id}(id)") }
        .run { mapper.toDTO(this) }


    fun getByName(destinationName: String) = repository.findDestinationByName(destinationName)
        .orElseThrow{ DestinationNotFoundException(destinationName) }

    fun getAll(pageable: Pageable) = repository.findAll(pageable).map(mapper::toDTO)
    fun update(body: DestinationUpdateRequest): DestinationResponse {
        val dest = repository.findById(body.id).orElseThrow { DestinationNotFoundException(body.id.toString()) }

        dest.update(body)

        return mapper.toDTO(dest)
    }

    fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}
