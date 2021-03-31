package Calendar;

import Helpers.Colors;

public class App {
    public static void main(String[] args) {
        Calendar cal = new Calendar(24, 3, 2021);
        System.out.println(cal.display());
        System.out.println(cal.nextDay(16));
        System.out.println(cal.previousMonth());
        System.out.println(cal.nextYear(5));

        System.out.println(Colors.BG_BLUE + Colors.BLACK + "Not-static methods" + Colors.RESET_COLOR);
        System.out.printf("%s.%s.%s\n", cal.getDay(), cal.getMonth(), cal.getYear());
        System.out.println("Day number in the week = " + cal.getWeekDay());
        System.out.println("Weekday = " + cal.getWeekDayToString());

        System.out.println();

        System.out.println(Colors.BG_BLUE + Colors.BLACK + "Static methods" + Colors.RESET_COLOR);
        System.out.println("Day number in the week for 25.01.2000 = " + Calendar.getWeekDay(25, 1, 2000));
        System.out.println("Weekday for 02.02.2030 = " + Calendar.getWeekDayToString(2, 2, 2030));

        System.out.println();

        Calendar cal1 = new Calendar(1, 2, 2000);
        System.out.println(cal1);
        System.out.println(cal1.nextYear());
    }
}
