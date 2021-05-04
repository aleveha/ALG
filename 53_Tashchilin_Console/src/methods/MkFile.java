package methods;

import java.io.File;
import java.io.IOException;

public class MkFile implements Helpable {
    public String act(String addr) throws IOException {
        File myObj = new File(addr);
        if (myObj.createNewFile()) {
            return "File created: " + myObj.getName();
        } else {
            return "File already exists.";
        }
    }

    @Override
    public String help() {
        return "mkfile <soubor> – vytvoří nový soubor, jehož jméno bylo zadáno v parametru";
    }
}
