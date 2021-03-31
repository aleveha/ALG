package Date;

public class Date {
    private int day, month, year;
    private final int[] daysInMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private enum WeekDays { Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday }
    private enum Months { January, February, March, April, May, June, July, August, September, October, November, December }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        setYear(year);
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public int[] getDaysInMonths() {
        return daysInMonths;
    }

    private void setYear(int year) {
        this.year = year;
        daysInMonths[2] = leapYear(year) ? 29 : 28;
    }

    public static String getWeekDayToString(int day, int month, int year) {
        return WeekDays.values()[getWeekDay(day, month, year) - 1].toString();
    }

    public static String getMonth(int month) {
        return Months.values()[month - 1].toString();
    }

    public static int getWeekDay(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;

        return ((((day + (((month + 1) * 26) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7) + 5) % 7) + 1;
    }

    public static boolean leapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public Date nextDay() {
        if (day == daysInMonths[month]) {
            this.day = 1;
            return nextMonth();
        } else {
            this.day++;
        }
        return new Date(day, month, year);
    }

    public Date nextDay(int days) {
        Date cal = new Date(day, month, year);
        for (int i = 0; i < days; i++) {
            cal = nextDay();
        }
        return cal;
    }

    public Date nextMonth() {
        if (month == 12) {
            this.month = 1;
            return nextYear();
        } else {
            this.month++;
        }
        return new Date(day, month, year);
    }

    public Date nextMonth(int months) {
        Date cal = new Date(day, month, year);
        for (int i = 0; i < months; i++) {
            cal = nextMonth();
        }
        return cal;
    }

    public Date nextYear() {
        setYear(++year);
        return new Date(day, month, year);
    }

    public Date nextYear(int years) {
        Date cal = new Date(day, month, year);
        for (int i = 0; i < years; i++) {
            cal = nextYear();
        }
        return cal;
    }

    // previous period
    public Date previousDay() {
        if (day == 1) {
            this.day = month != 1 ? daysInMonths[month - 1] : daysInMonths[12];
            return previousMonth();
        } else {
            this.day--;
        }
        return new Date(day, month, year);
    }

    public Date previousDay(int days) {
        Date cal = new Date(day, month, year);
        for (int i = 0; i < days; i++) {
            cal = previousDay();
        }
        return cal;
    }

    public Date previousMonth() {
        if (month == 1) {
            this.month = 12;
            return previousYear();
        } else {
            this.month--;
        }
        return new Date(day, month, year);
    }

    public Date previousMonth(int months) {
        Date cal = new Date(day, month, year);
        for (int i = 0; i < months; i++) {
            cal = previousMonth();
        }
        return cal;
    }

    public Date previousYear() {
        setYear(--year);
        return new Date(day, month, year);
    }

    public Date previousYear(int years) {
        Date cal = new Date(day, month, year);
        for (int i = 0; i < years; i++) {
            cal = previousYear();
        }
        return cal;
    }
}
