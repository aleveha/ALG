package bank;

import java.math.BigDecimal;

public class Account {
    // data
    private int id;
    private BigDecimal amount = new BigDecimal(0);

    // constructors
    public Account() {
    }

    public Account(BigDecimal amount) {
        this.amount = amount;
        this.id = (int) (Math.random() * 1000);
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
}
