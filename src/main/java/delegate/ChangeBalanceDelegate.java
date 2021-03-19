package delegate;

import java.net.URI;
import model.Operation;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import repository.AccountRepository;

/**
 * @author egor.oparin@x5.ru
 */

public class ChangeBalanceDelegate implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(ChangeBalanceDelegate.class);

    private final AccountRepository accountRepository;

    public ChangeBalanceDelegate(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void execute(DelegateExecution execution) throws Exception {
        String accountId = (String) execution.getVariable("accountId");
        String amount = (String) execution.getVariable("amount");
        String operation = (String) execution.getVariable("operation");
        String isRollback = (String) execution.getVariable("rollback");

        if (accountId == null || amount == null || operation == null) {
            return;
        }

        Integer id = Integer.parseInt(accountId);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:";

        if (id == 1) {
            url += "7777";
        }

        if (id == 2) {
            url += "8888";
        }

        url = url + "/operation";

        if(isRollback != null){
            url += "/rollback";
        }

        URI uri = new URI(url);

        Operation operationObj = new Operation(id, operation, Double.parseDouble(amount));

        String result = restTemplate.postForObject(uri, operationObj, String.class);

        if ( result != null && !result.equals("ok")){
            throw new BpmnError("eroor5555");
        }


//        if (operation == "+") {
//            account.setBalance(account.getBalance() + Integer.parseInt(amount));
//        }
//        if (operation == "-") {
//            account.setBalance(account.getBalance() - Integer.parseInt(amount));
//        }

        logger.info("Account $accountId, Operation $operation, Amount $amount");
    }
}
