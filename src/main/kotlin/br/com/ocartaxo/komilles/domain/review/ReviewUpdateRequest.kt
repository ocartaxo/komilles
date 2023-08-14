package br.com.ocartaxo.komilles.domain.review

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewUpdateRequest(
    val id: Int,
    @SerialName("depoimento")
    val review: String? = null,
    @SerialName("foto")
    val photo: String? = null
)
