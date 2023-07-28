package com.example.apigateway.demoapigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class AuthenticationFilter implements GatewayFilter {

    @Autowired
    private RouteValidator routerValidator;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (routerValidator.isSecured.test(request)) {
            if (this.isAuthMissing(request))
                return this.onError(exchange, "Authorization header is missing in request", HttpStatus.UNAUTHORIZED);

            String token = this.getAuthHeader(request);

            if (jwtUtil.isInvalid(token.substring(7)))
                return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);

            final String finalToken = token.substring(7);
//            System.out.println(finalToken);


//            System.out.println(roles);



//            exchange.getRequest().mutate()
//                    .header("id", String.valueOf(claims.getSubject()))
////                .header("role", String.valueOf(claims.get("role")))
//                    .build();
        }
        return chain.filter(exchange);
    }

    /*PRIVATE*/
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

//    private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {
//        final String finalToken = token.replace("Bearer ","");
//        Claims claims = jwtUtil.getAllClaimsFromToken(finalToken);
//        exchange.getRequest().mutate()
//                .header("id", String.valueOf(claims.getSubject()))
////                .header("role", String.valueOf(claims.get("role")))
//                .build();
//    }
}