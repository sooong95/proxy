package hello.proxy.config.v2_dynamicproxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyBasicConfig {

    @Bean
    public OrderControllerV2 orderController(LogTrace logTrace) {
        OrderControllerV2 orderController = new OrderControllerV1Impl(orderService(logTrace));

        return (OrderControllerV2) Proxy.newProxyInstance(orderController.getClass().getClassLoader(),
                new Class[]{orderController.getClass()}, new LogTraceBasicHandler(orderController, logTrace));
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace logTrace) {
        OrderServiceV2 orderService = new OrderServiceV1Impl(orderRepository(logTrace));

        return (OrderServiceV2) Proxy.newProxyInstance(orderService.getClass().getClassLoader(),
                new Class[]{orderService.getClass()}, new LogTraceBasicHandler(orderService, logTrace));
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl orderRepository = new OrderRepositoryV1Impl();

        return (OrderRepositoryV2) Proxy.newProxyInstance(orderRepository.getClass().getClassLoader(),
                new Class[]{orderRepository.getClass()}, new LogTraceBasicHandler(orderRepository, logTrace));
    }
}
