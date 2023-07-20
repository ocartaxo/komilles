package br.com.ocartaxo.komilles.controller

import br.com.ocartaxo.komilles.domain.statement.StatementRequest
import br.com.ocartaxo.komilles.domain.statement.StatementUpdateRequest
import br.com.ocartaxo.komilles.domain.statement.StatementsService
import com.nimbusds.jose.shaded.gson.Gson
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.*
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [StatementsController::class])
class StatementsControllerTest(@Autowired private val mockMvc: MockMvc) {

    @MockBean
    private lateinit var mockService: StatementsService

    @Test
    @WithMockUser
    fun `test if http status code is 201 when create an statement`() {

        val body = Gson().toJson(request)

        val mockRequest = MockMvcRequestBuilders.post(statementsUri)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(body)

        val response = mockMvc.perform(mockRequest)

        response.andExpect(status().isCreated)
    }

    companion object {
        private val request = StatementRequest(
            username = "João Neto",
            photo = "http://umaimagemqualquer.com.br",
            comment = "Gostei muito do local, tem um ar leve e paisagem muito belas. Recomendo que visitem!"
        )
        private val updateRequest = StatementUpdateRequest(
            id = 1,
            comment = "O local é bacana mas fiquei chateado por que o parque que eu fui estava fechado!"
        )

        private const val statementsUri = "http://localhost:8080/api/depoimentos"
    }

}