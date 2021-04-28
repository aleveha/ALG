package app;

import java.io.File;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String current;
        Console console;
        String userAnswer;

        current = new File( "." ).getAbsolutePath();
        console = new Console(current);

        do {
            userAnswer = sc.nextLine();

            String[] parts = userAnswer.split(" ");
            String command = parts[0].trim();
            String argument = console.getAddr();
            if (parts.length > 1) {
                argument = parts[1].trim();
            }
            String answer = "";

            switch (command) {
                case "dir":
                    answer = console.dir(argument);
                    break;
                case "cd":
                    console = console.cd(console.getAddr() + File.separator + argument);
                    System.out.println(console.getAddr());
                    break;
                case "help":
                    answer = console.help();
                    break;
            }

            System.out.println(answer);
        } while(!userAnswer.equals("exit"));
    }
}
