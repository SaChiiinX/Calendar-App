package program.model.Calendar;


import program.model.framework.Gathering;
import program.model.organizations.Event;
import program.model.utility.Sort;

import java.util.ArrayList;

public class Day {
    public int weekDay;
    // 1 - Sunday, 7 - Saturday
    public int day;
    // Day of the month
    public String date;
    //Full string representation of the date in YYYY-MM-DD
    int month;
    // 1 - January ... 12 - December
    int year;
    // this is the year as an int
    public ArrayList<Gathering> itinerary = new ArrayList<>();
    //List containing all the events for this day.
    public Day (int weekDay, int day, int month, int year) {
        this.weekDay = weekDay;
        this.day = day;
        this.month = month;
        this.year = year;
        date = ((this.month < 10) ? "0" : "") + month + "/" + ((this.day < 10) ? "0" : "") + day + "/" + year;
    }
    public void add (Event event) { itinerary.add(event); }
    // Add an event to our itinerary
    public void remove (Event event) { itinerary.remove(event); }
    //  an event
    private void orderItinerary () { Sort.timeSort(itinerary, false); }
    // Order the itinerary based on the event times
    public String toString () {
        // Print the contents of the sorted itinerary with the time range of the activities (start - end) and the name of the event
        orderItinerary();
        StringBuilder res = new StringBuilder();
        if (itinerary.size() == 0) return "Nothing planned for today!";
        for (Gathering item: itinerary) {
            res.append(item.range(true)).append(": ").append(item.name).append("\n");
        }
        return res.toString();
    }

}