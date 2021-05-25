package methods;

import java.io.File;
import java.util.Arrays;

public class Dir implements Helpable {
    public String act(String addr) {
        StringBuilder s = new StringBuilder();

        String[] pathNames = new File(addr).list();
        if (pathNames != null) Arrays.stream(pathNames).sorted().forEach(path -> s.append(path).append("\n"));

        return s.toString();
    }

    public String actRecurse(String addr) {
        StringBuilder s = new StringBuilder();

        File[] filesList = new File(addr).listFiles();

        if (filesList == null) return s.toString();

        for (File file : filesList) {
            s.append("–").append(file.getName()).append("\n");
            if (file.isDirectory()) {
                s.append("–").append(actRecurse(file.getAbsolutePath()));
            }
        }

        return s.toString();
    }

    @Override
    public String help() {
        return """
                dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře.
                dir <adress> – vrátí víceřádkový textový řetězec s formátovaným výpisem adresáře předaného v parametru, nemění aktuální adresář
                dir -r <adress> - vrátí rekurzivně všechny podadresáře a jejich podadresáře
                """;

    }
}
