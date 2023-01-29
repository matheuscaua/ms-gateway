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
                .route(rota -> rota.path("/controle")
                        .filters( gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/"))
                        .uri("lb://ms-controle-usuario"))
                .build();
    }

}
