package mtech.dev.marciosales.loja_virtual_mentoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = ("mtech.dev.marciosales.loja_virtual_mentoria.model"))
@ComponentScan(basePackages = {"mtech.*"})
@EnableJpaRepositories(basePackages ="mtech.dev.marciosales.loja_virtual_mentoria.repository")
@EnableTransactionManagement
public class LojaVirtualMentoriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
    }

}
