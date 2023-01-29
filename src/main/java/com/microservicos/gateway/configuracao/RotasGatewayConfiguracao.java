package com.microservicos.gateway.configuracao;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RotasGatewayConfiguracao {

    @Bean
    RouteLocator gateway(RouteLocatorBuilder rlb){
        return rlb.routes()
                .route(rota -> rota.path("/controle/usuario")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/controle/usuario/{nome}")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/{nome}"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/controle/usuario/cadastrar")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/cadastrar/"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/controle/usuario/{cpf}/{email}")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/{cpf}/{email}"))
                        .uri("lb://ms-controle-usuario"))
                .build();
    }

}
