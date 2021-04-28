package methods;

import java.io.File;
import java.util.Arrays;

public class Dir implements Helpable {
    public String act(String addr) {
        StringBuffer s = new StringBuffer();

        File file = new File(addr);
        String[] pathNames = file.list();
        Arrays.stream(pathNames).sorted().forEach(path -> s.append(path).append("\n"));

        return s.toString();
    }

    @Override
    public String help() {
        return "dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře.";
    }
}
