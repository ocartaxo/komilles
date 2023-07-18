package br.com.ocartaxo.komilles.infra.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
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
}