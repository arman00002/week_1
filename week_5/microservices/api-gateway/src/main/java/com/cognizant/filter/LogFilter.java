package main.java.com.cognizant.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import org.springframework.web.server.ServerWebExchange;

import java.util.logging.Logger;

@Component
public class LogFilter implements GlobalFilter, Ordered {

    private Logger logger = Logger.getLogger(LogFilter.class.getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        logger.info("Request Path: " + exchange.getRequest().getPath());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
