public class Runner implements Comparable<Runner> {
    // data
    private int number;
    private int finishTime;

    // constructors
    public Runner(int number, int finishTime) {
        this.number = number;
        this.finishTime = finishTime;
    }

    // getters
    public int getNumber() {
        return number;
    }
    public int getFinishTime() {
        return finishTime;
    }

    // setters
    public void setNumber(int number) {
        this.number = number;
    }
    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    //methods
    public int timeDifference(int time) {
        return finishTime - time;
    }

    @Override
    public String toString() {
        return "Runner {" + "number = " + number + ", finishTime = " + finishTime + '}';
    }

    @Override
    public int compareTo(Runner o) {
        return Integer.compare(finishTime, o.getFinishTime());
    }
}
