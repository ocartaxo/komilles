package br.com.ocartaxo.komilles.domain.destination

import jakarta.persistence.*

@Entity
@Table(name="destinos")
data class Destination(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name="nome")
    val name: String,
    @Column(name="foto")
    var photo: String,
    @Column(name="preco")
    var price: Double
) {
    fun update(body: DestinationUpdateRequest){
        this.photo = body.photo ?: this.photo
        this.price = body.price ?: this.price
    }
}
