package bank;

import java.math.BigDecimal;

public class Account {
    // data
    private static int accountsCounter = 0;
    private int id;
    private BigDecimal amount = new BigDecimal(0);

    // constructors
    public Account() {
        this.id = ++accountsCounter;
    }

    public Account(BigDecimal amount) {
        this();
        this.amount = amount;
    }

    // for coping
    public Account(Account account){
        this(account.amount, account.id);
    }

    public Account(BigDecimal amount, int id) {
        this.amount = amount;
        this.id = id;
    }

    // getters
    public BigDecimal getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    // setters
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // methods
    public void addAmount(BigDecimal amount) {
        setAmount(this.amount.add(amount));
    }

    public boolean withdraw(BigDecimal amount) {
        if (!(this.amount.subtract(amount).compareTo(BigDecimal.valueOf(0)) > 0)) {
            return false;
        }
        setAmount(this.amount.subtract(amount));
        return true;
    }
}
