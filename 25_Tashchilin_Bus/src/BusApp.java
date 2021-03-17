import java.util.Scanner;

public class BusApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bus universityBus = new Bus(41, 15, "DPMLJ");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%d. zastavka%s\n", i + 1, i == 4 ? ". Konecna" : "");

            if (i != 4) {
                System.out.println(universityBus.getBusInfo());
                System.out.println("Kolik cestujících chce vystoupit a kolik chce nastoupit?");
                universityBus.dropOff(sc.nextInt());
                universityBus.pickUp(sc.nextInt());
            }
            else universityBus.dropOffAllPeople();

            System.out.println(universityBus.getBusInfo());
            System.out.println();
        }
    }
}
