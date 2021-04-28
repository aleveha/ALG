import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String current;
        Console console;
        try {
            current = new File( "." ).getCanonicalPath();
            console = new Console(current);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Path can't be empty");
        }

        System.out.println(console.dir());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(console.dir("../"));
    }
}
