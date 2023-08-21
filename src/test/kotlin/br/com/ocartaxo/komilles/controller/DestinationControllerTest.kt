package br.com.ocartaxo.komilles.controller

import br.com.ocartaxo.komilles.domain.destination.DestinationTest
import br.com.ocartaxo.komilles.domain.review.ReviewTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.*
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DestinationControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    companion object {
        private const val RECURSO = "/api/destinos"
    }

    @BeforeEach
    fun beforeEach() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder> {
                SecurityMockMvcConfigurers.springSecurity()
            }
            .build()
    }

    @BeforeEach
    fun clearDatabase(@Autowired flyway: Flyway) {
        flyway.clean()
        flyway.migrate()
    }

    @Test
    fun `deve retornar 201 ao criar um destino`() {
        mockMvc.post(RECURSO) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = Json.encodeToString(DestinationTest.buildRequest())
        }.andExpect {
            status { isCreated() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `deve retornar código 200 ao pesquisar por destino`() {

        mockMvc.post(RECURSO) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = Json.encodeToString(DestinationTest.buildRequest())
        }

        mockMvc.get("$RECURSO/1") {}
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                content { json(ReviewTest.buildExpectedReviewResponse()) }
            }
    }

    @Test
    fun `deve retornar código 200 após atualizar o depimento`() {
        val (request, updateRequest) = DestinationTest.buildRequestToUpdate()

        mockMvc.post(RECURSO) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = Json.encodeToString(request)
        }

        mockMvc.put(RECURSO) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = Json.encodeToString(updateRequest)
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }

    }

    fun `deve retornar status code 401 quando deletar o depoimento da base`() {
        mockMvc.delete("$RECURSO/1") { }
            .andExpect { status { isNoContent() } }
    }

}