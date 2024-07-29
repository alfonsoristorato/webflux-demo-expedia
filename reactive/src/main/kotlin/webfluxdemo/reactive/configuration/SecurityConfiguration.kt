package webfluxdemo.reactive.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(useAuthorizationManager = true)
class SecurityConfiguration {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
        http
            .authorizeExchange { authorize ->
                authorize
                    .pathMatchers("/actuator/**")
                    .permitAll()
                    .anyExchange()
                    .authenticated()
            }
            .oauth2ResourceServer { oauth2 ->
                oauth2
                    .jwt(Customizer.withDefaults())
            }
            .build()
}
