package ru.x5.bpn.camunda.saga;

import delegate.ChangeBalanceDelegate;
import delegate.ErrorSimulatorDelegate;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.AccountRepository;

/**
 * @author egor.oparin@x5.ru
 */
@Configuration
public class DelegateConfiguration {

    @Bean
    JavaDelegate changeBalanceDelegate (AccountRepository acountRepository ) {
        return new ChangeBalanceDelegate(acountRepository);
    }

    @Bean
    JavaDelegate errorSimulatorDelegate() {
        return new ErrorSimulatorDelegate();
    }

}
