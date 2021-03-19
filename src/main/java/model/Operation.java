package model;

/**
 * @author egor.oparin@x5.ru
 */
public class Operation {

    Integer accountId;
    String operation;
    Double amount;

    public Operation(Integer accountId, String operation, Double amount) {
        this.accountId = accountId;
        this.operation = operation;
        this.amount = amount;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
