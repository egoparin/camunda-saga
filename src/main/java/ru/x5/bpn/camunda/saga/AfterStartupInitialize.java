package ru.x5.bpn.camunda.saga;

import model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import repository.AccountRepository;

/**
 * @author egor.oparin@x5.ru
 */
public class AfterStartupInitialize implements ApplicationListener<ApplicationReadyEvent> {

    private Logger logger = LoggerFactory.getLogger(AfterStartupInitialize.class);

    @Autowired
    private AccountRepository accountRepository;

    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Account account1 = new Account(1, 0.0);
        Account account2 = new  Account(2, 0.0);
        accountRepository.save(account1);
        accountRepository.save(account2);

        logger.info(">>> Init done, accounts created");
    }
}
