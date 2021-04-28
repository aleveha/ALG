import methods.Dir;

public class Console {
    private final String addr;

    public Console(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public String dir() {
        return new Dir().act(getAddr());
    }

    public String dir(String addr) {
        return new Dir().act(addr);
    }

}
