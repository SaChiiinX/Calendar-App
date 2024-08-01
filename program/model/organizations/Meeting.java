package program.model.organizations;
import program.model.framework.NamedObject;
import java.util.InputMismatchException;

public class Meeting extends Event {
    //Need to add controller to prevent GB members from attending EB meetings
    //represents regularly occurring meetings for clubs
    public boolean GB;

    public Meeting (String start, String end, String date, boolean GB, String location, String host) {
        super ("Meeting", start, end, date, "", location, host);
        this.GB = GB;
    }

    public void addOrRemove (NamedObject elem, boolean add) {
        //add to rsvp list
        if (elem.thisClassType.equals("Club") && !info2.isEmpty()) return;
        if (elem.thisClassType.equals("Event")) throw new InputMismatchException();
        else connection(elem, add);
    }
    public void makePrivate (boolean no) { GB = no; }

    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append(info2.get(0)).append("'s ").append((GB) ? "general board": "executive board").append(" meeting");
        res.append("\n").append(getTime(true, false)).append("\n").append(range(true)).append("\n").append(location);
        return res.toString();
    }
}
