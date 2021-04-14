public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double average;

    public Student(Integer id, String firstName, String lastName, Double average) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
    }

    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.2f", getId(), getLastName(), getFirstName(), getAverage());
    }
}
