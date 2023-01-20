package com.microservicos.gateway.configuracao;



import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguracao {

   /* @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/ms-controle-usuario/**")
                        .uri("lb:/ms-controle-usuario/"))
                .build();
    }*/
}
