package program.model.organizations;
import program.model.framework.ClubData;
import program.model.framework.Gathering;
import program.model.framework.NamedObject;
import java.util.InputMismatchException;


public class Event extends Gathering {
    public Club host;
    public Event () {}
    public boolean isPrivate;

    public Event (String name, String startTime, String endTime, String startDate, String endDate, String location, String host) {
        thisClassType = "Event";
        info1ClassType = "Club";
        info2ClassType = "user";
        this.name = name;
        setTime(startTime, true, true);
        setTime(endTime, false, true);
        setTime(startDate, true, false);
        if (!endDate.equals("")) setTime(endDate, false, false);
        else endDate = startDate;
        this.location = location;
        if (!host.equals("")) {
            this.host = ClubData.get(host);
            connection(this.host, true);
        } else this.host = null;
    }

    public Event (String name, String startDate, String startTime, String endTime, String location) {
        this.name = name;
        setTime(startDate, false, true);
        setTime(startTime, true, true);
        setTime(endTime, false, true);
        this.location = location;
    }

    public void addOrRemove (NamedObject elem, boolean add) {
        //Add or remove clubs form their collaborators list or users from their rsvp list
        if (elem.thisClassType.equals("Event")) throw new InputMismatchException();
        else connection(elem, add);
    }

    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append(name).append("\n").append(range(false)).append(range(true)).append(location);
        res.append("\nHosted by: ").append((host != null) ? host.name : "").append("\nCollaborators: ");
        for (int i = 1; i < info2.size(); i++) {
            res.append(info2.get(i)).append((i == info2.size() - 1) ? "" : ", ");
        }
        return res.toString();
    }

    public String getClassType(){return this.thisClassType;}
    public String getClassType1(){return this.info1ClassType;}

    public String getClassType2(){return this.info2ClassType;}

    public String getName(){return this.name;}

    public
}
