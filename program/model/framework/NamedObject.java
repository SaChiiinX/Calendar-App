package program.model.framework;

import java.util.ArrayList;

public abstract class NamedObject {
    //Represents anything with a name

    public String thisClassType;
    public String info1ClassType;
    public String info2ClassType;

    public String name;
    String abbreviation;
    public ArrayList<String> info1 = new ArrayList<>();

    //info1 and info2 represent places to store data to each object's personal collection
    //for example, a club's list of members or events, or a user's personal list of clubs they are in
    // and events they are attending. An event would use these as an rsvp list and a list of collaborating clubs.
    public ArrayList<String> info2 = new ArrayList<>();

    public String getName () { return this.name; }
    public void setName (String name) { this.name = name; }
    public String getAbbreviation () { return abbreviation; }
    public void setAbbreviation (String abbreviation) { this.abbreviation = abbreviation; }

    public ArrayList<String> view (boolean list1) {
        if (list1) return info1;
        return info2;
    }

    public abstract void addOrRemove (NamedObject elem, boolean add);

    public void connection (NamedObject addend, boolean addOrRemove) {
        //Updates the data collections of two named events,
        // for instance a user adding a club will need to add that club to their personal list of clubs,
        // and the club needs to add the user to their list of members
       if (thisClassType.equalsIgnoreCase(addend.info1ClassType)) {
           if (addOrRemove) {
               info1.add(addend.name);
               addend.info2.add(this.name);
           } else {
               info1.remove(addend.name);
               addend.info2.remove(this.name);
           }
       } else if (thisClassType.equalsIgnoreCase(addend.info2ClassType)) {
           if (addOrRemove){
               info2.add(addend.name);
               addend.info1.add(this.name);
           } else {
               info2.remove(addend.name);
               addend.info1.remove(this.name);
           }
       }
    }

}
