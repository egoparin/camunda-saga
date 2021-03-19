package delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.Random;

/**
 * @author egor.oparin@x5.ru
 */
public class ErrorSimulatorDelegate implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {

        String amount = (String) execution.getVariable("amount");
        double errorAmount = Double.parseDouble(amount);

        boolean error = false;
        if (errorAmount == 22) {
            error = true;
        }

        if (errorAmount == 44) {
            throw new RuntimeException("Interrupt saga");
        }

//        Random random = new Random();
//        double digit = random.nextGaussian();
//
//        boolean error = false;
//
//        if (digit > 0.6) {
//            error = true;
//        }
        execution.setVariable("error", error);
    }
}
