package com.microservicos.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class MsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGatewayApplication.class, args);

    }
    @Bean
    RouteLocator gateway(RouteLocatorBuilder rlb){
        return rlb.routes()
                .route(rota -> rota.path("/controle")
                        .filters( gatewayFilterSpec -> gatewayFilterSpec.setPath("/usuario/"))
                        .uri("lb://ms-controle-usuario"))
                .build();
    }

}
