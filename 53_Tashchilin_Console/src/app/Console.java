package app;

import methods.*;

import java.io.File;
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
                new Cd().help(),
                new MkFile().help(),
                new MkDir().help(),
                new MkDirs().help(),
                new Rename().help()
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
        return new Cd().act(this.addr + File.separator + addr);
    }

    public boolean mkfile(String addr) throws IOException {
        return new MkFile().act(this.addr + File.separator + addr);
    }

    public boolean mkdir(String addr) {
        return new MkDir().act(addr);
    }

    public boolean mkdirs(String addr) {
        return new MkDirs().act(addr);
    }

    public boolean rename(String[] files) throws IOException {
        return new Rename().act(this.addr + File.separator + files[0], this.addr + File.separator + files[1]);
    }
}
