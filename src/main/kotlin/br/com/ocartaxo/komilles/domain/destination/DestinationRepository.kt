package br.com.ocartaxo.komilles.domain.destination

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DestinationRepository : JpaRepository<Destination, Int>{
    fun findDestinationByName(name: String): Optional<Destination>
}
