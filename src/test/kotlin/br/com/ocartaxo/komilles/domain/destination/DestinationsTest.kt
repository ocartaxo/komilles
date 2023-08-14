package br.com.ocartaxo.komilles.domain.destination

object DestinationsTest {
    fun buildRequest() = DestinationRequest(
        name = "Livramento de Nossa Senhora",
        photo = "http://randomphoto.com",
        price = 1000.0
    )

    fun buildExpectedResponse() = "{ \"id\": 1, \"nome\": \"Livramento de Nossa Senhora\", \"foto\": \"http://randomphoto.com\", \"preco\": 1000.0 }"


    fun buildUpdateRequest() = DestinationUpdateRequest(
        id = 1,
        price = 1000000.00,
        photo = "http://anotherrandomphoto.com"
    )

    fun buildExpectedReviewResponseAfterUpdate() = "{ \"id\": 1, \"nome\": \"Livramento de Nossa Senhora\", \"foto\": \"http://anotherrandomphoto.com\", \"preco\": 1000000.0 }"

}