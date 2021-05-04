package methods;

import java.io.File;

public class MkDir implements Helpable {

    public String act(String addr) {
        File myObj = new File(addr);
        if (myObj.mkdir()) {
            return "Dir created: " + myObj.getName();
        } else {
          return "Dir already exists.";
        }
    }

    @Override
    public String help() {
        return "mkdir <adresář> - vytvoří zadaný adresář";
    }

}
