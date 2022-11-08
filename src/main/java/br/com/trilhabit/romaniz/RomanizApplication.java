package br.com.trilhabit.romaniz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
    "br.com.trilhabit.romaniz.model"
})
@EnableJpaRepositories(basePackages = {
    "br.com.trilhabit.romaniz.repository"
})
public class RomanizApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanizApplication.class, args);
    }

}
