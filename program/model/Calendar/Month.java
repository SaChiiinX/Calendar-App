package program.model.Calendar;

import java.util.Calendar;

public enum Month {
    JANUARY(1, "Jan"), FEBRUARY(2, "Feb"), MARCH(3, "Mar"), APRIL(4, "Apr"),
    MAY(5, "May"), JUNE(6, "Jun"), JULY(7, "Jul"), AUGUST(8, "Aug"),
    SEPTEMBER(9, "Sep"), OCTOBER(10, "Oct"), NOVEMBER(11, "Nov"), DECEMBER(12, "Dec");
    public final int id;
    // The numerical representation for month
    public String shortened;
    // Shortened version of the month name - the first three letters
    boolean leapYear;
    // Checks if the month is in a leap year
    public Day[] days;
    // Array of the days in the month, fixed from 28-31 days
    Month(int i, String shortened) {
        id = i;
        this.shortened = shortened;
        switch (i) {
            // set the number of days in the month based on a leap year and the month itself
            case (2) -> days = (leapYear) ? new Day[29]: new Day[28];
            case (1), (3), (5), (7), (8), (10), (12) -> days = new Day[31];
            case (4), (11), (6), (9) -> days = new Day[30];
        }
    }

    public void fill (boolean leap, int year) {
        // Fill the days array with day objects
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < days.length; i++) {
            c.set(year, id - 1, i + 1);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            days[i] = new Day(dayOfWeek, i + 1, id, year);
        }
    }

    public String toString() {
        // Prints view of the entire month
        String spaceUnit = "    ";
        String topCol = "------------" + this.shortened + "------------ ";
        String weekCol = "Sun Mon Tue Wed Thu Fri Sat ";
        StringBuilder resBuilder = new StringBuilder(topCol + "\n" + weekCol + "\n");
        int dayOfWeek = days[0].weekDay;
        int lineCount = 0;
        for (int i = 0; i < days.length; i++) {
            if (i == 0) {
                for (int j = 1; j < dayOfWeek; j++) resBuilder.append(spaceUnit);
                resBuilder.append(" ").append(0).append(days[i].day).append(" ").append((dayOfWeek == 7) ? "\n" : "");
                if (dayOfWeek == 7) dayOfWeek = 1;
                else dayOfWeek++;
                continue;
            }
            resBuilder.append(" ").append((days[i].day < 10) ? 0 : "").append(days[i].day).append(" ");
            if (dayOfWeek == 7) {
                resBuilder.append("\n");
                dayOfWeek = 0;
                lineCount++;
            }
            dayOfWeek++;
        }
        String repeatCustom = spaceUnit.repeat(7 - ((dayOfWeek == 1) ? 0: dayOfWeek - 1));
        String repeatSeven = spaceUnit.repeat(7);
        if (lineCount == 3) {
            if (dayOfWeek == 1) resBuilder.append("\n").append(repeatSeven).append("\n").append(repeatSeven);
            else resBuilder.append(repeatCustom).append('\n').append(repeatSeven);
        } else if (lineCount == 4)
            resBuilder.append(repeatCustom).append('\n').append(repeatSeven);
        else resBuilder.append(repeatCustom);
        return resBuilder.toString();
    }
}
