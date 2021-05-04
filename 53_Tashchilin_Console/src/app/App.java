package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String current;
        Console console;
        String userAnswer;

        current = new File("").getAbsolutePath();
        console = new Console(current);

        do {
            userAnswer = sc.nextLine();

            String[] parts = userAnswer.split(" ", 2);
            String command = parts[0].trim();
            String argument = console.getAddr();
            if (parts.length > 1) {
                argument = parts[1].trim();
            }
            boolean emptyArgument = argument.trim().equals(console.getAddr());
            String answer;

            switch (command) {
                case "dir":
                    answer = emptyArgument ? console.dir() : console.dir(argument);
                    break;
                case "cd":
                    if (emptyArgument) argument = "";

                    console = console.cd(argument);
                    answer = console.getAddr() + "\n";
                    break;
                case "mkfile":
                    if (emptyArgument) {
                        answer = "Empty argument!\n";
                        break;
                    }

                    try {
                        answer = console.mkfile(argument) ? "File successfully created.\n" : "File already exists.\n";
                    } catch (IOException ex) {
                        answer = ex.getMessage();
                    }
                    break;
                case "mkdir":
                    argument = console.getAddr() + File.separator + argument;
                    answer = emptyArgument ? "Empty argument!\n" : console.mkdir(argument);
                    break;
                case "mkdirs":
                    argument = console.getAddr() + File.separator + argument;
                    answer = emptyArgument ? "Empty argument!\n" : console.mkdirs(argument);
                    break;
                case "rename":
                    if (emptyArgument) {
                        answer = "Empty argument!\n";
                        break;
                    }

                    String[] files = argument.split(" ", 2);
                    try {
                        answer = console.rename(files) ? "File successfully renamed.\n" : "Something went wrong.\n";
                    } catch (IOException ex) {
                        answer = ex.getMessage();
                    }
                    break;
                default:
                    answer = console.help();
                    break;
            }

            System.out.println(answer);
        } while (!userAnswer.equals("exit"));
    }
}
