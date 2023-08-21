package br.com.ocartaxo.komilles.infra.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {

        return OpenAPI()
            .info(
                Info()
                    .title("KoMilles API")
                    .description(
                        """
                            API REST da aplicação Jornada Milhas para disponibilizar endpoints para depoimentos e destinos.
                        """.trimIndent()
                    )
                    .contact(
                        Contact()
                            .name("Otávio Cartaxo")
                            .email("oacartaxo@gmail.com")

                    )
                    .license(
                        License()
                            .name("MIT License")
                            .url("https://adopet.org/licenca")
                    )
            )

    }
}