package methods;

import java.io.File;

public class MkDirs implements Helpable {
    public boolean act(String path) {
        File f = new File(path);

        return f.mkdirs();
    }


    @Override
    public String help() {
        return "mkdirs <cesta> – vytvoří adresáře odpovídající cestě zadané v parametru\n";
    }
}

