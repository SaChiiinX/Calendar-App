package program.model.organizations;
import program.model.Calendar.Calendar;
import program.model.framework.NamedObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Club extends NamedObject {

    // Representation of clubs

    Calendar calendar = new Calendar(LocalDate.now().getYear());
    public Meeting regularMeeting;

    public ArrayList<Meeting> regularMeetings;
    //repeating meetings, will refined in future
    String[] tags;

    public Club (String name, String[] tags) throws Exception{
        thisClassType = "Club";
        info1ClassType = "user";
        info2ClassType = "Event";
        this.name = name;
        this.tags = tags;
    }
    public Club (String name) {
        thisClassType = "Club";
        info1ClassType = "Event";
        info2ClassType = "user";
        this.name = name;
    }

    public void addOrRemove (NamedObject elem, boolean add) {
        // Add or remove users and events to the clubs collection of data
        if (elem.thisClassType.equals("Club")) throw new InputMismatchException();
        else if (elem instanceof Event) calendar.synchronize(((Event) elem).getTime(true, false), (Event) elem);
        connection(elem, add);
    }

    public void setRegular(String start, String end, String date, boolean GB, String location) {
        //Set regular repeating meeting, will be refined in the future
        regularMeeting = new Meeting(start, end, date, GB, location, name);
    }

    public String toString () {
        //Prints representation of the club with name, meeting time, etc.
        String res = "";
        res += name + "\n" + "Tags: ";
        for (int i = 0; i < tags.length; i++)
            res += tags[i] + ((i != tags.length - 1) ? ", " : "\n");
        res += regularMeeting.toString();
        return res;
    }

    public String getClassType(){return this.thisClassType;}
    public String getClassType1(){return this.info1ClassType;}

    public String getClassType2(){return this.info2ClassType;}
    public String getName(){return this.name;}


}
