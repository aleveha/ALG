package methods;

import java.io.File;
import java.io.IOException;

public class MkFile implements Helpable {
    public boolean act(String addr) throws IOException {
        File file = new File(addr);
        return file.createNewFile();
    }

    @Override
    public String help() {
        return "mkfile <soubor> – vytvoří nový soubor, jehož jméno bylo zadáno v parametru";
    }
}
