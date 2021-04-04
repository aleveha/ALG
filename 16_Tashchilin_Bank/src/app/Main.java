package app;

import bank.Account;
import bank.Client;
import bank.Company;
import bank.Person;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static Helpers.Colors.*;

public class Main {
    public static void main(String[] args) {
        // create new clients
        Person baker = new Person("Pekar", new Account(BigDecimal.valueOf(100), 556));
        Person teacher = new Person("Svecova");
        Company autoCompany = new Company("Skoda");
        Company itCompany = new Company("IBM", new Account(BigDecimal.valueOf(35000), 296));

        // add them to to array
        Client[] clients = new Client[]{baker, teacher, autoCompany, itCompany};

        // add client's accounts
        baker.addAccount(new Account(BigDecimal.valueOf(2000), 559));
        try {
            baker.addAmount(559, BigDecimal.valueOf(3000));
        } catch (NoSuchElementException ex) {
            System.out.println(RED + ex.getMessage());
            System.out.println();
        }
        baker.addAccount(new Account(BigDecimal.valueOf(1000), 560));
        baker.addAccount(new Account(BigDecimal.valueOf(4000), 562));

        teacher.addAccount(new Account(BigDecimal.valueOf(200), 685));
        try {
            teacher.addAmount(559, BigDecimal.valueOf(3000));
        } catch (NoSuchElementException ex) {
            System.out.println(RED + ex.getMessage());
            System.out.println();
        }
        teacher.addAccount(new Account(BigDecimal.valueOf(1000), 686));
        teacher.addAccount(new Account(BigDecimal.valueOf(400), 684));

        autoCompany.addAccount(new Account(BigDecimal.valueOf(29000), 203));
        autoCompany.addAccount(new Account(BigDecimal.valueOf(26000), 204));
        try {
            autoCompany.addAmount(204, BigDecimal.valueOf(2000));
        } catch (NoSuchElementException ex) {
            System.out.println(RED + ex.getMessage());
            System.out.println();
        }

        System.out.println(BG_GREEN + BLACK + "Before sorting" + RESET_COLOR);
        for (Client client : clients) {
            System.out.println(client.getClientName() + ", " + client.getAllAmount());
        }

        Arrays.sort(clients);
        System.out.println();
        System.out.println(BG_GREEN + BLACK + "After sorting" + RESET_COLOR);
        for (Client client : clients) {
            System.out.println(client.getClientName() + ", " + client.getAllAmount());
        }
    }
}
