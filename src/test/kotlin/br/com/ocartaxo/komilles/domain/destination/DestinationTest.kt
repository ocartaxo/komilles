package br.com.ocartaxo.komilles.domain.destination

object DestinationTest {

    fun buildRequest() = DestinationCreateRequest(
        name = "Livramento de Nossa Senhora",
        price = 1000.0,
        thumbnailPhoto = "http://randomthumbphoto.com",
        optionalPhoto = "http://randomoptionalphoto.com",
        description = "Um lugar com lindas cachoeiras e rios!",
        meta = "Venha conhecer o portal da Chapada Diamantina!"
    )

    fun buildRequestToUpdate(): Pair<DestinationCreateRequest, DestinationUpdateRequest> {
        val request = DestinationCreateRequest(
            name = "Salvador",
            price = 1600.0,
            thumbnailPhoto = "http://randomphoto.com",
            optionalPhoto = "http://randomoptionalphoto.com",
            description = "Essa cidade histórica possuí lindas praias e belos pontos turísticos!",
            meta = "Venha conhecer a capital da Bahia!"
        )

        val updateRequest = DestinationUpdateRequest(
            id = 1,
            price = 2000.0,
            meta = "Venha conhecer a cidade do carnaval!"
        )

        return Pair(request, updateRequest)
    }

    fun buildRequestWithEmptyDescription() = DestinationCreateRequest(
        name = "Rio de Contas",
        price = 600.0,
        thumbnailPhoto = "http://randomphoto.com",
        optionalPhoto = "http://randomoptionalphoto.com"
    )


}