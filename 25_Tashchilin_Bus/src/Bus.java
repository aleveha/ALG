public class Bus {
    private final int seats;
    private int number;
    private int peopleAmount;
    private String owner;

    //constructors
    public Bus(int seats, int number, String owner) {
        this.seats = seats;
        this.number = number;
        this.owner = owner;
    }
    public Bus() {
        this.seats = 40;
        this.owner = "";
    }

    //getters
    /**
     *
     * @return Return an amount of seats
     */
    public int getSeats() {
        return seats;
    }
    /**
     *
     * @return Return a bus number
     */
    public int getNumber() {
        return number;
    }
    /**
     *
     * @return Return people amount inside a bus
     */
    public int getPeopleAmount() {
        return peopleAmount;
    }
    /**
     *
     * @return Return bus company name
     */
    public String getOwner() {
        return owner;
    }

    //setters
    /**
     *
     * @param number bus number (only positive value)
     */
    public void setNumber(int number) {
        if (number <= 0) throw new IllegalArgumentException("Argument can not be negative or equal to zero");
        this.number = number;
    }
    /**
     *
     * @param owner company name (not-empty string)
     */
    public void setOwner(String owner) {
        if (owner.equals("")) throw new IllegalArgumentException("Argument can not be empty string");
        this.owner = owner;
    }

    //methods
    /**
     *
     * @return Return information about bus as a string
     */
    public String getBusInfo() {
        return String.format("Autobus číslo %d společnosti %s s počtem sedadel %d veze %d cestujicich", number, owner, seats, peopleAmount);
    }
    /**
     *
     * @param peopleAmount amount of people to drop off (only positive value)
     */
    public void dropOff(int peopleAmount) {
        if (peopleAmount < 0) throw new IllegalArgumentException("Argument can not be negative");
        this.peopleAmount = peopleAmount <= this.peopleAmount ? this.peopleAmount - peopleAmount : 0;
    }
    public void dropOffAllPeople() {
        this.peopleAmount = 0;
    }
    /**
     *
     * @param peopleAmount amount of people to pick up (only positive value)
     */
    public void pickUp(int peopleAmount) {
        if (peopleAmount < 0) throw new IllegalArgumentException("Argument can not be negative");
        this.peopleAmount = peopleAmount > (this.seats - this.peopleAmount) ? this.seats : this.peopleAmount + peopleAmount;
    }
}