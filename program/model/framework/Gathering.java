package program.model.framework;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Gathering extends NamedObject implements Comparable<Gathering> {
    //Represents any congregation of people

    protected LocalTime startTime;
    protected LocalTime endTime;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    protected String location;

    public String getTime (boolean start, boolean time) {
        //retrieve the time as a string, if start is false, will get endTime, if time is false will get date
        if (time) return ((start) ? startTime : endTime).format(formatter);
        return ((start) ? startDate : endDate).toString();
    }

    public void setTime (String time, boolean start, boolean timeOrDate) {
        // Set time or date to a custom input
        boolean AM = time.contains("AM");
        String value = time.replaceAll("\\D+", "");
        int first = 0;
        if (!timeOrDate) first = Integer.parseInt(value.substring(0,2));
        else first = Integer.parseInt(value.substring(0,2)) + ((!AM && !time.startsWith("12")) ? 12 : 00);
        int second = Integer.parseInt(value.substring(2, 4));

        if (timeOrDate) {
            if (start) startTime = LocalTime.of(first, second);
            else endTime = LocalTime.of(first, second);
        } else {
            if (start) startDate = LocalDate.of(LocalDate.now().getYear(), first, second);
            else endDate = LocalDate.of(LocalDate.now().getYear(), first, second);
        }
    }

    public String range (boolean time) {
        //show both the start and end time for an event
        if (time) return getTime(true, true) + " to " + getTime(false, true);
        else return getTime(true, false) + " to " + getTime(false, false);
    }

    public String getLocation () { return location; }
    //For location methods will be utilized in the future.
    public void setLocation (String location) { this.location = location; }
    public int compareTo (Gathering o) {
        if (startDate.compareTo(o.startDate) != 0) return startDate.compareTo(o.startDate);
        else return startTime.compareTo(o.startTime);
    }
}
