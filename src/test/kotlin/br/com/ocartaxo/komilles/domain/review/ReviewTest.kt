package br.com.ocartaxo.komilles.domain.review

object ReviewTest {
    fun buildRequest() = ReviewRequest(
        username = "Joao da Silva",
        review = "Esse lugar é muito bonito!! Recomendo que visitem!",
        photo = "http://randomphoto.com"
    )

    fun buildExpectedReviewResponse() = "{ \"id\": 1, \"usuario\": \"Joao da Silva\", \"depoimento\": \"Esse lugar é muito bonito!! Recomendo que visitem!\", \"foto\": \"http://randomphoto.com\" }"

    fun buildUpdateRequest() = ReviewUpdateRequest(
        id = 1,
        review = "Esse lugar é maravilhoso!! Pretendo voltar mais vezes futuramente!",
        photo = "http://anotherrandomphoto.com"
    )

    fun buildExpectedReviewResponseAfterUpdate() = "{ \"id\": 1, \"usuario\": \"Joao da Silva\", \"depoimento\": \"Esse lugar é maravilhoso!! Pretendo voltar mais vezes futuramente!\", \"foto\": \"http://anotherrandomphoto.com\" }"


}