package cl.fseguel.awlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author fseguel
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan("cl.fseguel.awlog")
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"cl.fseguel.awlog.repository"})
@EntityScan(basePackages = {"cl.fseguel.awlog.models"})
public class AwlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwlogApplication.class, args);
    }

}
