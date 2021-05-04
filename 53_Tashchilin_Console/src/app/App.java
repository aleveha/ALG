package app;

import java.io.File;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String current;
        Console console;
        String userAnswer;

        current = new File(".").getAbsolutePath();
        console = new Console(current);

        do {
            userAnswer = sc.nextLine();

            String[] parts = userAnswer.split(" ", 2);
            String command = parts[0].trim();
            String argument = console.getAddr();
            if (parts.length > 1) {
                argument = parts[1].trim();
            }
            boolean emptyArgument = argument.equals(console.getAddr());
            String answer = "";

            switch (command) {
                case "dir":
                    argument = console.getAddr() + File.separator + argument;
                    answer = emptyArgument ? console.dir() : console.dir(argument);
                    break;
                case "cd":
                    argument = console.getAddr() + File.separator + argument;
                    console = console.cd(argument);
                    break;
                case "mkfile":
                    argument = console.getAddr() + File.separator + argument;
                    answer = emptyArgument ? "Empty argument!" : console.mkfile(argument);
                    break;
                case "mkdir":
                    argument = console.getAddr() + File.separator + argument;
                    answer = emptyArgument ? "Empty argument!" : console.mkdir(argument);
                    break;
                case "mkdirs":
                    argument = console.getAddr() + File.separator + argument;
                    answer = emptyArgument ? "Empty argument!" : console.mkdirs(argument);
                    break;
                case "rename":
                    answer = emptyArgument ? "Empty argument!" : console.rename(argument);
                    break;
                default:
                    answer = console.help();
                    break;
            }

            System.out.println(answer);
        } while (!userAnswer.equals("exit"));
    }
}
