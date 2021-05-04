package app;

import methods.*;

import java.io.IOException;
import java.util.Arrays;

public class Console {
    private final String addr;

    public Console(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public String help() {
        StringBuffer s = new StringBuffer();

        String[] helpActions = new String[]{
                new Dir().help(),
                new Cd().help()
        };

        Arrays.stream(helpActions).forEach(method -> s.append(method).append("\n\n"));

        return s.toString();
    }

    public String dir() {
        return new Dir().act(getAddr());
    }

    public String dir(String addr) {
        return new Dir().act(addr);
    }

    public Console cd(String addr) {
        return new Cd().act(addr);
    }

    public String mkfile(String addr) {
        try {
            return new MkFile().act(addr);
        } catch (IOException ex) {
            return "An error occurred during creating new file.";
        }
    }

    public String mkdir(String addr) {
        return new MkDir().act(addr);
    }

    public String mkdirs(String addr) {
        return new MkDirs().act(addr);
    }

    public String rename(String args) {
        String[] files = args.split(" ", 2);
        return new Rename().act(files[0], files[1]);
    }
}
