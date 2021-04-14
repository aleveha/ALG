import Helpers.Colors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Mike", "Fanek", 2.5));
        students.add(new Student(3, "Tom", "Lord", 2.0));
        students.add(new Student(2, "Alice", "Acile", 1.5));
        students.add(new Student(4, "Bob", "Herany", 3.6));

        Comparator<Student> sortById = Comparator.comparing(Student::getId);
        Comparator<Student> sortByFirstName = Comparator.comparing(Student::getFirstName);
        Comparator<Student> sortByLastName = Comparator.comparing(Student::getLastName);
        Comparator<Student> sortByAverage = Comparator.comparing(Student::getAverage);

        UI(students, "Not sorted", (o1, o2) -> 0);
        UI(students,"Sorted by id", sortById);
        UI(students,"Sorted by first name", sortByFirstName);
        UI(students,"Sorted by last name", sortByLastName);
        UI(students,"Sorted by average", sortByAverage);
    }

    private static void UI(List<Student> students, String label, Comparator<Student> sortBySomething) {
        System.out.println(Colors.BG_GREEN + Colors.BLACK + label + Colors.RESET_COLOR);
        students.sort(sortBySomething);
        students.forEach(System.out::println);
        System.out.println();
    }
}
