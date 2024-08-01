package program.model.Calendar;

import program.model.framework.Gathering;

public class Calendar {
    //Overall Calendar class, that contains a singular year
    boolean leap;
    //True for leap year, false for not
    public Year year;
    // Year field containing the calendar information

    public String firstDayOfSchool;
    //The start of the Vassar school year in YYYY-MM-DD form
    public String lastDayOfSchool;
    //The last day of the Vassar school year (finals week not counted), same format as first day
    public Calendar (int year) {
        // Making specific calendar based on inputted year
        leap = year % 4 == 0;
        //Calculating leap year
        this.year = new Year (leap, year);
    }

    public Month getMonth (int month) { return year.months[month - 1]; }
    public Day getDay (int day, int month) { return year.months[month - 1].days[day - 1]; }
    public Year getYear () { return year; }

    public void synchronize (String date, Gathering gathering) {
        //Update the calendar information with events, date is date of the event, gathering is the meeting or event object being synced
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        year.months[month - 1].days[day - 1].itinerary.add(gathering);
    }
}