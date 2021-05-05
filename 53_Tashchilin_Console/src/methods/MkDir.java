package methods;

import java.io.File;

public class MkDir implements Helpable {

    public boolean act(String addr) {
        File myObj = new File(addr);
        return myObj.mkdir();
    }

    @Override
    public String help() {
        return "mkdir <adresář> - vytvoří zadaný adresář";
    }

}
