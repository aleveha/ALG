import java.time.LocalDate;

public class Calendar {
    // data
    private int day, month, year;
    private final LocalDate currentDate;
    private final int[] daysInMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructors
    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        currentDate = LocalDate.now();
        daysInMonths[2] = leapYear(year) ? 29 : 28;
    }

    // getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // public methods
    public int getWeekDay(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;

        return ((((day + (((month + 1) * 26) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7) + 5) % 7) + 1;
    }

    public String getWeekDayToString(int day, int month, int year) {
        return switch (getWeekDay(day, month, year)) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Sunday";
        };
    }

    public String getMonth(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            default -> "December";
        };
    }

    // next period
    public Calendar nextDay() {
        if (day == daysInMonths[month]) {
            this.day = 1;
            return nextMonth();
        } else {
            this.day++;
        }
        return new Calendar(day, month, year);
    }

    public Calendar nextDay(int days) {
        Calendar cal = new Calendar(day, month, year);
        for (int i = 0; i < days; i++) {
            cal = nextDay();
        }
        return cal;
    }

    public Calendar nextMonth() {
        if (month == 12) {
            this.month = 1;
            return nextYear();
        } else {
            this.month++;
        }
        return new Calendar(day, month, year);
    }

    public Calendar nextMonth(int months) {
        Calendar cal = new Calendar(day, month, year);
        for (int i = 0; i < months; i++) {
            cal = nextMonth();
        }
        return cal;
    }

    public Calendar nextYear() {
        this.year++;
        return new Calendar(day, month, year);
    }

    public Calendar nextYear(int years) {
        Calendar cal = new Calendar(day, month, year);
        for (int i = 0; i < years; i++) {
            cal = nextYear();
        }
        return cal;
    }

    // previous period
    public Calendar previousDay() {
        if (day == 1) {
            this.day = month != 1 ? daysInMonths[month - 1] : daysInMonths[12];
            return previousMonth();
        } else {
            this.day--;
        }
        return new Calendar(day, month, year);
    }

    public Calendar previousDay(int days) {
        Calendar cal = new Calendar(day, month, year);
        for (int i = 0; i < days; i++) {
            cal = previousDay();
        }
        return cal;
    }

    public Calendar previousMonth() {
        if (month == 1) {
            this.month = 12;
            return previousYear();
        } else {
            this.month--;
        }
        return new Calendar(day, month, year);
    }

    public Calendar previousMonth(int months) {
        Calendar cal = new Calendar(day, month, year);
        for (int i = 0; i < months; i++) {
            cal = previousMonth();
        }
        return cal;
    }

    public Calendar previousYear() {
        this.year--;
        return new Calendar(day, month, year);
    }

    public Calendar previousYear(int years) {
        Calendar cal = new Calendar(day, month, year);
        for (int i = 0; i < years; i++) {
            cal = previousYear();
        }
        return cal;
    }

    public static boolean leapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public String display() {
        StringBuilder s = new StringBuilder(Colors.BG_GREEN + Colors.BLACK + "    " + getMonth(month) + "   " + getYear() + "    " + Colors.RESET_COLOR + "\n");
        s.append(Colors.CYAN + "Mo Tu We Th Fr Sa Su" + Colors.RESET_COLOR + "\n");
        int weekCounter = 0;
        int monthStart = getWeekDay(1, month, year);
        for (int i = 1; i <= daysInMonths[month] + monthStart - 1; i++) {
            int day = i - monthStart + 1;
            if ((i + weekCounter) % 8 == 0) {
                s.append("\n");
                weekCounter++;
            }

            if (i < monthStart && monthStart != 1)
                s.append("   ");
            else if (exactDay(day))
                s.append(String.format("%s%s", Colors.BG_RED + Colors.BLACK + (String.format("%2d", day)), Colors.RESET_COLOR + " "));
            else if (day == this.day)
                s.append(Colors.BRIGHT_GREEN).append(String.format("%2d ", day)).append(Colors.RESET_COLOR);
            else
                s.append(String.format("%2d ", day));
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return display();
    }

    // private methods
    private boolean exactDay(int day) {
        return day == currentDate.getDayOfMonth() && month == currentDate.getMonth().getValue() && year == currentDate.getYear();
    }

    //test
    public static void main(String[] args) {
        Calendar cal = new Calendar(24, 3, 2021);
        System.out.println(cal.display());
        System.out.println(cal.nextDay(16));
    }
}
