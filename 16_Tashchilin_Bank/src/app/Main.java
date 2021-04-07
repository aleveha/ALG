package app;

import bank.*;

import java.math.BigDecimal;
import java.util.*;

import static Helpers.Colors.*;

public class Main {
    public static void main(String[] args) {
        // create new clients
        Person baker = new Person("Pekar", new Account(BigDecimal.valueOf(100)));
        Person teacher = new Person("Svecova");
        Company autoCompany = new Company("Skoda");
        Company itCompany = new Company("IBM", new Account(BigDecimal.valueOf(35000)));

        // add them to to array
        Client[] clients = new Client[]{baker, teacher, autoCompany, itCompany};
        List<Client> cli = new ArrayList<>();
        cli.add(baker);
        cli.add(teacher);
        cli.add(autoCompany);
        cli.add(itCompany);

        // add client's accounts
        baker.addAccount(new Account(BigDecimal.valueOf(1000)));
        baker.addAccount(new Account(BigDecimal.valueOf(500)));

        teacher.addAccount(new Account(BigDecimal.valueOf(1200)));

        autoCompany.addAccount(new Account(BigDecimal.valueOf(120)));

        System.out.println(BG_GREEN + BLACK + "Before sorting" + RESET_COLOR);
//        for (Client client : clients) {
//            System.out.println(client.getClientName() + ", " + client.getAllAmount());
//        }

        for (Client client : cli) {
            System.out.println(client.getClientName() + ", " + client.getAllAmount());
        }

        ////// sorting by implementing Comparable interface //////
//         Arrays.sort(clients);

        ////// sorting by using Comparator //////
//         Arrays.sort(clients, new Comparator<Client>() {
//             @Override
//             public int compare(Client c1, Client c2) {
//                 return c1.getAllAmount().compareTo(c2.getAllAmount());
//             }
//         })
//         Arrays.sort(clients, (c1, c2) -> c1.getAllAmount().compareTo(c2.getAllAmount()));
//         Arrays.sort(clients, Comparator.comparing(Client::getAllAmount));

        // sorting by using method referencing
        Arrays.sort(clients, Client::sort);

        Collections.sort(cli);

        System.out.println();
        System.out.println(BG_GREEN + BLACK + "After sorting" + RESET_COLOR);
//        for (Client client : clients) {
//            System.out.println(client.getClientName() + ", " + client.getAllAmount());
//        }

        for (Client client : cli) {
            System.out.println(client.getClientName() + ", " + client.getAllAmount());
        }
    }
}
