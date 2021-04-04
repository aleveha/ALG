package bank;

public class Company extends Client {
    // constructors
    public Company(String name) {
        super(name, new Account());
    }

    public Company(String name, Account account) {
        super(name, account);
    }

    // methods
    @Override
    public String getClientName() {
        return "firma " + super.getName();
    }
}
