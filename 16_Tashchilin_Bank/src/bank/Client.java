package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Client implements Comparable<Client> {
    // data
    private String name;
    private List<Account> accounts = new ArrayList<>(5);

    // constructors
    public Client(String name) {
        this.name = name;
    }

    public Client(String name, Account account) {
        this(name);
        this.accounts.add(new Account(account));
    }

    // getters
    public String getName() {
        return name;
    }

    // methods
    public BigDecimal getAllAmount() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Account account : accounts) {
            sum = sum.add(account.getAmount());
        }
        return sum;
    }

    public void addAccount(Account account) {
        if (accounts.size() == 5) throw new IllegalAccountAmountException("More than 5 accounts is not supported");

        if (existsAccount(account.getId()) == null) accounts.add(new Account(account));
        else addAmount(account.getId(), account.getAmount());
    }

    public void addAmount(int id, BigDecimal amount) {
        if (accounts.isEmpty()) throw new NullPointerException("You do not have any accounts yet");

        if (existsAccount(id) == null) throw new NoSuchElementException("No account match");

        existsAccount(id).addAmount(amount);
    }

    private Account existsAccount(int id) {
        return accounts.stream().filter(account -> id == account.getId()).findAny().orElse(null);
    }

    public abstract String getClientName();

    ////// sorting by implementing Comparable interface //////
    @Override
    public int compareTo(Client o) {
        return this.getAllAmount().compareTo(o.getAllAmount());
    }

    ////// sorting by using method referencing //////
    public int sort(Client o) {
        return this.getAllAmount().compareTo(o.getAllAmount());
    }
}