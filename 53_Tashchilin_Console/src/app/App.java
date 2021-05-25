package app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
                    if (emptyArgument) {
                        answer = console.dir();
                        break;
                    }

                    String[] arguments = argument.split(" ", 2);
                    try {
                        answer = arguments.length == 1 && !arguments[0].contains("-") ? console.dir(argument) : console.dir(arguments);
                    } catch (IllegalArgumentException ex) {
                        answer = ex.getMessage();
                    }
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
                    if (emptyArgument) {
                        answer = "Empty argument!\n";
                        break;
                    }

                    answer = console.mkdir(argument) ? "Directory successfully created.\n" : "Directory cannot be crated.\n";
                    break;
                case "mkdirs":
                    if (emptyArgument) {
                        answer = "Empty argument!\n";
                        break;
                    }

                    answer = console.mkdirs(argument) ? "Directories successfully created.\n" : "Directories cannot be created\n";
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
