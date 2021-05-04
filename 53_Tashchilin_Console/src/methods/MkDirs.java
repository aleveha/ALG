package methods;

import java.io.File;

public class MkDirs implements Helpable {
    public String act(String path) {
        File f = new File(path);

        if (f.mkdirs()) {
            return "Directory is now created";
        } else {
            return "Directory cannot be created";
        }
    }


    @Override
    public String help() {
        return "mkdir <adresář> - vytvoří zadaný adresář";
    }
}

