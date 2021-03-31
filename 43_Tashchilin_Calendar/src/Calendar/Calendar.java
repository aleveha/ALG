package Calendar;

import Helpers.Colors;
import java.time.LocalDate;
import Date.Date;

public class Calendar {
    // data
    private final Date date;
    private final LocalDate currentDate = LocalDate.now();

    // constructors
    public Calendar(int day, int month, int year) {
        date = new Date(day, month, year);
    }
    public Calendar(Date date) {
        this.date = date;
    }

    // getters
    public int getDay() {
        return date.getDay();
    }
    public int getMonth() {
        return date.getMonth();
    }
    public int getYear() {
        return date.getYear();
    }

    //methods
    public static String getWeekDayToString(int day, int month, int year) {
        return Date.getWeekDayToString(day, month, year);
    }
    public String getWeekDayToString() {
        return Date.getWeekDayToString(date.getDay(), date.getMonth(), date.getYear());
    }
    public static int getWeekDay(int day, int month, int year) {
        return Date.getWeekDay(day, month, year);
    }
    public int getWeekDay() {
        return Date.getWeekDay(date.getDay(), date.getMonth(), date.getYear());
    }

    // next period
    public Calendar nextDay() {
        return new Calendar(date.nextDay());
    }
    public Calendar nextDay(int days) {
        return new Calendar(date.nextDay(days));
    }
    public Calendar nextMonth() {
        return new Calendar(date.nextMonth());
    }
    public Calendar nextMonth(int months) {
        return new Calendar(date.nextMonth(months));
    }
    public Calendar nextYear() {
        return new Calendar(date.nextYear());
    }
    public Calendar nextYear(int years) {
        return new Calendar(date.nextYear(years));
    }

    // previous period
    public Calendar previousDay() {
        return new Calendar(date.previousDay());
    }
    public Calendar previousDay(int days) {
        return new Calendar(date.previousDay(days));
    }
    public Calendar previousMonth() {
        return new Calendar(date.previousMonth());
    }
    public Calendar previousMonth(int months) {
        return new Calendar(date.previousMonth(months));
    }
    public Calendar previousYear() {
        return new Calendar(date.previousYear());
    }
    public Calendar previousYear(int years) {
        return new Calendar(date.previousYear(years));
    }

    // display calendar
    public String display() {
        StringBuilder s = new StringBuilder(Colors.BG_GREEN + Colors.BLACK + "    " + Date.getMonth(date.getMonth()) + "   " + date.getYear() + "    " + Colors.RESET_COLOR + "\n");
        s.append(Colors.CYAN + "Mo Tu We Th Fr Sa Su" + Colors.RESET_COLOR + "\n");
        int weekCounter = 0;
        int monthStart = Date.getWeekDay(1, date.getMonth(), date.getYear());
        for (int i = 1; i <= date.getDaysInMonths()[date.getMonth()] + monthStart - 1; i++) {
            int day = i - monthStart + 1;
            if ((i + weekCounter) % 8 == 0) {
                s.append("\n");
                weekCounter++;
            }

            if (i < monthStart && monthStart != 1)
                s.append("   ");
            else if (exactDay(day))
                s.append(String.format("%s%s", Colors.BG_RED + Colors.BLACK + (String.format("%2d", day)), Colors.RESET_COLOR + " "));
            else if (day == this.date.getDay())
                s.append(Colors.BRIGHT_GREEN).append(String.format("%2d ", day)).append(Colors.RESET_COLOR);
            else
                s.append(String.format("%2d ", day));
        }
        s.append("\n");
        return s.toString();
    }

    @Override
    public String toString() {
        return display();
    }

    // private methods
    private boolean exactDay(int day) {
        return day == currentDate.getDayOfMonth() && date.getMonth() == currentDate.getMonth().getValue() && date.getYear() == currentDate.getYear();
    }
}
