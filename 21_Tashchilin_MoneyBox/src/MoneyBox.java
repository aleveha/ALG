public class MoneyBox {
    private int oneCoinCounter;
    private int twoCoinCounter;
    private String owner;

    //constructors
    public MoneyBox(String owner) {
        this.owner = owner;
    }
    public MoneyBox(String owner, int oneCoinCounter, int twoCoinCounter) {
        this.owner = owner;
        this.oneCoinCounter = oneCoinCounter;
        this.twoCoinCounter = twoCoinCounter;
    }

    //setters
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void addOneCoin() {
        this.oneCoinCounter++;
    }
    public void addTwoCoin() {
        this.twoCoinCounter++;
    }

    public void addCoins(int oneCoinCounter, int twoCoinCounter) {
        this.oneCoinCounter += oneCoinCounter;
        this.twoCoinCounter += twoCoinCounter;
    }

    public int spendAllMoney() {
        int sum = getSum();
        this.oneCoinCounter = 0;
        this.twoCoinCounter = 0;
        return sum;
    }

    public void addOneCoinAmount(int oneCoinAmount) {
        this.oneCoinCounter += oneCoinAmount;
    }

    //getters
    public String getOwner() {
        return this.owner;
    }
    public int getOneCoinCounter() {
        return oneCoinCounter;
    }
    public int getTwoCoinCounter() {
        return twoCoinCounter;
    }

    public int getSum() {
        return oneCoinCounter + twoCoinCounter * 2;
    }

    public String getMoneyBoxInfo() {
        return String.format("%s ma v pokladnicce %dKc: %dx1Kc, %dx2Kc", owner, getSum(), this.oneCoinCounter, this.twoCoinCounter);
    }

    public boolean refinePrice(int price) {
        return price < getSum();
    }
}
