package br.com.ocartaxo.komilles.domain.destination

import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
object DestinationMapper {
    
    fun toDTO(destination: Destination) = DestinationResponse(
        id = destination.id!!,
        name = destination.name,
        thumbPhoto = destination.thumbnailPhoto,
        price = destination.price,
        description = destination.description!!,
        photo = destination.optionalPhoto,
        meta = destination.meta
    )

    fun toEntity(destination: DestinationCreateRequest) = Destination(
        name = destination.name,
        thumbnailPhoto = destination.thumbnailPhoto,
        optionalPhoto = destination.optionalPhoto,
        price = destination.price,
        description = destination.description ?: throw RuntimeException("Descrição do destino está vazia!"),
        meta = destination.meta
    )

}