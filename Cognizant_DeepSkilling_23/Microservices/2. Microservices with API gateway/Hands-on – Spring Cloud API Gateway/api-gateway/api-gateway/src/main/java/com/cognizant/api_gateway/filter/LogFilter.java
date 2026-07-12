package com.cognizant.api_gateway.filter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter, Ordered {

    // To verify that Spring creates this bean
    public LogFilter() {
        System.out.println("LogFilter Loaded");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("====================================");
        System.out.println("Incoming Request");
        System.out.println("Method : " + exchange.getRequest().getMethod());
        System.out.println("URI    : " + exchange.getRequest().getURI());
        System.out.println("====================================");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}