package ru.x5.bpn.camunda.saga;

import model.Account;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repository.AccountRepository;

@EnableProcessApplication
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {AccountRepository.class})
@EntityScan(basePackageClasses = {Account.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
