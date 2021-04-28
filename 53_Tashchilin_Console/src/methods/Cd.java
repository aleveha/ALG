package methods;

import app.Console;

import java.io.File;

public class Cd implements Helpable{
    public Console act(String addr) {
        return new Console(new File(addr).getAbsolutePath());
    }

    @Override
    public String help() {
        return "cd <address> – změna aktuálního adresáře dle para";
    }
}
