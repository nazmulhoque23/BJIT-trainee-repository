package com.example.BookService.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestInterceptor implements Filter {
    private final DiscoveryClient discoveryClient;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        int apiGatewayPort = callOtherServiceName("APIGATEWAY");
        int bookServicePort = callOtherServiceName("BOOK-SERVICE");
        int currentPort = servletRequest.getServerPort();

        if(   apiGatewayPort == 0 && currentPort == bookServicePort){
            String msg = "Request through API gateway: 8090";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(msg.getBytes());
            outputStream.flush();
            return;
        }
//        byte[] requiredResponse = response.getCharacterEncoding().getBytes();
//        String responseDataString = new String(requiredResponse, StandardCharsets.UTF_8);
//        HttpServletResponse servletResponse = (HttpServletResponse) response;
//
//        servletResponse.setContentType("application/json");
//        servletResponse.setStatus(HttpServletResponse.SC_OK);
////            servletResponse.getWriter().write(responseDataString);
//
//        OutputStream outputStream = servletResponse.getOutputStream();
//        outputStream.write(responseDataString.substring(10).getBytes());
//        outputStream.flush();

//        chain.doFilter(request, servletResponse);
//        else if(apiGatewayPort == 8090){
//
//        }
        chain.doFilter(request, response);
    }

    public Integer callOtherServiceName(String serviceName){
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if(instances.isEmpty()){
            return 0;
        }
        else{
            ServiceInstance instance = instances.get(0);
            String hostName = instance.getServiceId();
            if(hostName.equals(serviceName)){
                int port = instance.getPort();
                return port;
            }
            return null;
        }
    }
}
