package br.com.ocartaxo.komilles.domain.destination

import org.springframework.stereotype.Component

@Component
object DestinationMapper {
    
    fun toDTO(d: Destination) = DestinationResponse(
        id = d.id!!,
        name = d.name,
        photo = d.photo,
        price = d.price
    )

    fun toEntity(d: DestinationCreateRequest) = Destination(
        name = d.name,
        photo = d.photo,
        price = d.price
    )

}