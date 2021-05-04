package methods;

import java.io.File;
import java.io.IOException;

public class Rename implements Helpable {
    public boolean act(String file1, String file2) throws IOException {
        File oldFile = new File(file1);
        File newFile = new File(file2);

        System.out.println(oldFile);
        System.out.println(newFile);

        if (!oldFile.exists()) {
            throw new IOException("File does not exist");
        }
        if (newFile.exists()) {
            throw new IOException("File already exists");
        }

        return oldFile.renameTo(newFile);
    }

    @Override
    public String help() {
        return "rename <jm1> <jm2> – přejmenuje soubor nebo adresář";
    }
}
