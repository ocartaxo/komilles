package br.com.ocartaxo.komilles.domain.destination

import org.springframework.stereotype.Component

@Component
object DestinationMapper {
    
    fun toDTO(destination: Destination) = DestinationResponse(
        id = destination.id!!,
        name = destination.name,
        photo = destination.thumbnailPhoto,
        price = destination.price
    )

    fun toEntity(destination: DestinationCreateRequest) = Destination(
        name = destination.name,
        thumbnailPhoto = destination.thumbnailPhoto,
        optionalPhoto = destination.optionalPhoto,
        price = destination.price,
        description = destination.description,
        meta = destination.meta
    )

}