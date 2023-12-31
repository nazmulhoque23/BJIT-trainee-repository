package com.example.apigateway.apigateway.config;

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
            if (this.isAuthMissing(request)){

                HttpStatus statusCode = HttpStatus.UNAUTHORIZED;
                exchange.getResponse().setStatusCode(statusCode);

                // Create the response body
                String responseBody = "Custom message: " + statusCode.value() + " - " + statusCode.getReasonPhrase();
                byte[] responseBytes = responseBody.getBytes();

                // Set the response body and complete
                return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(responseBytes)))
                        .then(Mono.fromRunnable(() -> exchange.getResponse().setComplete()));
//                return this.onError(exchange, "Authorization header is missing in request", HttpStatus.UNAUTHORIZED);
            }

            String token = this.getAuthHeader(request);

            if (jwtUtil.isInvalid(token)){
                return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);
            }
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
        return request.getHeaders().getOrEmpty("Authorization").get(0).substring(7);
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