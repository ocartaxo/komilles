package br.com.ocartaxo.komilles.infra.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
class SecurityConfigs {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain? {

        http.authorizeHttpRequests { requests -> requests.anyRequest().permitAll() }

        return http.build()
    }

    @Bean
    fun corsConfiguration(): CorsConfigurationSource {

        val corsConfig = CorsConfiguration()
        corsConfig.setAllowedOriginPatterns(arrayListOf("http://localhost:3000"))
        corsConfig.allowedMethods = arrayListOf(
            "GET",
            "POST",
            "PUT",
            "PATCH",
            "DELETE"
        )

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)
        return source
    }
}