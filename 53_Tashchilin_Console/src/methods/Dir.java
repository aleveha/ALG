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

    @Override
    public String help() {
        return "dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře.\n" +
                "dir <adress> – vrátí víceřádkový textový řetězec s formátovaným výpisem adresáře předaného v parametru, nemění aktuální adresář";

    }
}
