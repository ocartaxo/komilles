package br.com.ocartaxo.komilles.domain.destination

import jakarta.persistence.*

@Entity
@Table(name = "destinos")
data class Destination(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "nome")
    val name: String,
    @Column(name = "preco")
    var price: Double = 0.0,
    @Column(name = "foto1")
    var thumbnailPhoto: String,
    @Column(name = "descricao")
    var description: String,
    @Column(name = "foto2")
    var optionalPhoto: String? = null,
    @Column(name = "_meta")
    var meta: String? = null
) {
    fun update(body: DestinationUpdateRequest) {
        this.thumbnailPhoto = body.thumbnailPhoto ?: this.thumbnailPhoto
        this.optionalPhoto = body.photo
        this.price = body.price ?: this.price
        this.description = body.description ?: this.description
        this.meta = body.meta
    }
}
