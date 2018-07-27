package app.springboot.demo;

import app.springboot.demo.utils.TomcatCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "spring/demo.xml")
public class DemoApplication {

    @Value("${server.port}")
    private int port;

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new TomcatCustomizer(port);
    }


    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);


    }



}
