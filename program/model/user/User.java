package program.model.user;

import program.model.Calendar.Calendar;
import program.model.framework.NamedObject;
import program.model.organizations.Club;
import program.model.organizations.Event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class User extends NamedObject {
    //represents a user for the app

    public String email;
    private String password;
    public Calendar calendar;

    public User (String name) {
        thisClassType = "user";
        info1ClassType = "Event";
        info2ClassType = "Club";
        this.name = name;
        calendar = new Calendar(LocalDate.now().getYear());
    }

    public void addOrRemove (NamedObject elem, boolean add) {
        //add or remove to the user's personal data collection
        if (elem instanceof User) throw new InputMismatchException();
        else if (elem instanceof Club) calendar.synchronize(((Club) elem).regularMeeting.getTime(true, false), ((Club) elem).regularMeeting);
        else calendar.synchronize(((Event) elem).getTime(true, false), (Event) elem);
        connection(elem, add);
    }

    public ArrayList<String> get (boolean clubOrEvent) {
        // info2: clubs, info1: events
        if (clubOrEvent) return info2;
        return info1;
    }

    public String getClassType(){return this.thisClassType;}
    public String getClassType1(){return this.info1ClassType;}

    public String getClassType2(){return this.info2ClassType;}

    public String getName(){return this.name;}

    public Calendar getCalendar(){return this.calendar;}

}
