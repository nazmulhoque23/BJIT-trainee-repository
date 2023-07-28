package com.example.apigateway.demoapigateway.config;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RoleBasedFilter extends AbstractGatewayFilterFactory<RoleBasedFilter.Config> {
    @Autowired
    private JwtUtil jwtUtil;
//    private static final String BASE_PATH = "/api";
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            System.out.println(request.getHeaders());
            System.out.println(request.getURI().getPath());
            String token = request.getHeaders().getOrEmpty("Authorization").get(0);
//                    extractTokenFromRequest(request);
            final String finalToken = token.substring(7);
            Claims claims = jwtUtil.getAllClaimsFromToken(finalToken);
            List<Map<String, String>> rolesFromJwt = (List<Map<String, String>>) claims.get("roles");
            List<String> roles = rolesFromJwt.stream()
                    .map(role-> role.get("authority"))
                    .collect(Collectors.toList());
            System.out.println(roles);
            if(hasRequiredRoles(roles, request)){
                return chain.filter(exchange);
            }
            else{
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }

        };

    }
    public boolean hasRequiredRoles(List<String> roles, ServerHttpRequest request){
        Map<String, List<String>> requiredRolesForAccess = new HashMap<>();
        requiredRolesForAccess.put("book", Arrays.asList("CUSTOMER","ADMIN"));
        requiredRolesForAccess.put("book1", Arrays.asList("ADMIN"));
        requiredRolesForAccess.put("inventory", Arrays.asList("ADMIN"));
        String currentRouteId = getCurrentRouteId(request);
        List<String> requiredRoles = requiredRolesForAccess.get(currentRouteId);
        return roles.stream().anyMatch(requiredRoles::contains);
    }

    public String getCurrentRouteId(ServerHttpRequest request){
        String path = request.getURI().getPath();
        if(path.startsWith("/book-service/book")){
            return "book";
        }else if(path.startsWith("/book-service/create-book")){
//            ||path.startsWith("/book-service/update")||path.startsWith("/book-service/delete")
            return "book1";
        }
        else if(path.startsWith("/inventory-service")){
            return "inventory";
        }
        return null;
    }
//    private String extractTokenFromRequest (ServerHttpRequest request){
//        return
//        HttpHeaders headers = request.getHeaders();
//        System.out.println(headers.getOrEmpty("Authorization").get(0));
//        List<String> authorizationHeaders = headers.getOrEmpty("Authorization");
//        if (authorizationHeaders != null && !authorizationHeaders.isEmpty()) {
//            String authorizationHeader = authorizationHeaders.get(0);
//            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//                return authorizationHeader.substring(7); // Extract the token after "Bearer "
//            }
//        }
//        return null; // Return null if token is not found in the request headers
//    }
    public static class Config {
        private List<String> requiredRoles;

        public Config(List<String> requiredRoles){
            this.requiredRoles =requiredRoles;
        }

        public List<String> getRequiredRoles() {
            return requiredRoles;
        }

//        public void setRequiredRoles(List<String> requiredRoles) {
//            this.requiredRoles = requiredRoles;
//        }
    }
}