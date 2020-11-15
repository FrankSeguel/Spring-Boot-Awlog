package cl.fseguel.awtolog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author fseguel
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan("cl.fseguel.awtolog")
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"cl.fseguel.awtolog.model.repository"})
@EntityScan(basePackages = {"cl.fseguel.awtolog.model.entity"})
@EnableAspectJAutoProxy
public class AwtoLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwtoLogApplication.class, args);
    }

}
