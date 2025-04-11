package hello.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
public class BasicTest {

    @Test
    void basicConfig() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(); // 스프링 컨테이너

        A beanA = ac.getBean("beanA", A.class);
        beanA.helloA();
    }

    @Configuration
    static class BasicConfig {

        @Bean(name = "beanA")
        public A a() {
            return new A();
        }
    }

    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }
}
