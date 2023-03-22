package com.microservicos.gateway.controlador.configuracao;


import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

@Configuration
public class RotasGatewayConfiguracao {

    @Bean
    RouteLocator gateway(RouteLocatorBuilder builder){
        return builder.routes()
                .route(rota -> rota.path("/usuario")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/usuario/{nome}")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/{nome}"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/usuario/cadastrar")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/cadastrar/"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/usuario/{cpf}/{email}")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/{cpf}/{email}"))
                        .uri("lb://ms-controle-usuario"))
                .route(rota -> rota.path("/posts/criarPosts")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/posts/criarPosts"))
                        .uri("lb://ms-posts")
                )
                .build();
    }


    @Bean
    public HttpClient httpClient() {
        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    }

}
