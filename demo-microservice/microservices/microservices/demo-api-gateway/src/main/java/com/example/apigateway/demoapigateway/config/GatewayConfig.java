package com.example.apigateway.demoapigateway.config;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter1;

    @Autowired
    RoleBasedFilter roleFilter;

//    private static final String BASE_PATH = "/api";

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("book", r -> r.path("/book-service/book/**")
                        .filters(f->f.filter(filter1).filter(roleFilter.apply(new RoleBasedFilter.Config(Arrays.asList("ROLE_USER","ROLE_ADMIN")))))
                        .uri("lb://book-app"))
                .route("book1", r->r.path("/book-service/create-book/**")
//                        .and().path("/book-service/update/**")
//                        .and().path("/book-service/delete/**")
                        .filters(f->f.filter(filter1).filter(roleFilter.apply(new RoleBasedFilter.Config(Arrays.asList("ROLE_ADMIN")))))
                        .uri("lb://book-app"))
                .route("inventory", r->r.path("/inventory-service/**")
                        .filters(f-> f.filter(filter1).filter(roleFilter.apply(new RoleBasedFilter.Config(Arrays.asList("ROLE_ADMIN")))))
                        .uri("lb://inventory-app"))

//
//                .route("auth-app", r -> r.path("/api/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://auth-app"))
                .build();
    }

}
