package app;

import methods.Cd;
import methods.Dir;

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

        String[] helpActions = new String[] {
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
}
