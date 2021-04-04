package bank;

public class Person extends Client {
    // constructors
    public Person(String name) {
        super(name, new Account());
    }

    public Person(String name, Account account) {
        super(name, account);
    }

    // methods
    @Override
    public String getClientName() {
        String name = super.getName();
        return String.format("%s %s", name.endsWith("ova") ? "pani" : "pan", name);
    }
}
