package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class TestFilter implements GatewayFilter, Ordered {

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LocaleContext context = exchange.getLocaleContext();
        System.err.println(context.getLocale());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            System.err.println("执行过滤器"+ exchange.getResponse().getStatusCode());
        }));
    }



}