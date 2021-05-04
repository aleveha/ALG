package methods;

import java.io.File;

public class Rename implements Helpable {
    public String act(String file1, String file2) {
        String answer;
        File oldFile = new File(file1);
        File newFile = new File(file2);

        if (!oldFile.exists()) {
            return "File does not exist";
        }
        if (newFile.exists()) {
            return "File already exists";
        }

        boolean success = oldFile.renameTo(newFile);
        answer = success ? "File successfully renamed." : "Something went wrong.";

        return answer;
    }

    @Override
    public String help() {
        return "rename <jm1> <jm2> – přejmenuje soubor nebo adresář";
    }
}
