package Math;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class DaysBetweenTwoDates {

    static final int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDays(date1) - getDays(date2));
    }

    private int getDays(String date) {
        int y = Integer.parseInt(date.substring(0, 4)), m = Integer.parseInt(date.substring(5, 7)), d = Integer.parseInt(date.substring(8, 10));
        int days = 0;
        for (int i = 1971; i < y; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 0; i < m - 1; i++) {
            days += this.days[i];
        }
        if (isLeapYear(y) && m > 2) {
            days++;
        }
        days += d;
        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 100 != 0 && year % 4 == 0) || year % 400 == 0;
    }


    public static void main(String[] args) {
        DaysBetweenTwoDates dd = new DaysBetweenTwoDates();
        String date1 = "2020-01-15", date2 = "2019-12-31";
        System.out.println(dd.daysBetweenDates(date1, date2));
    }
}
