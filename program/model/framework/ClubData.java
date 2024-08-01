package program.model.framework;

import program.model.organizations.Club;

import java.util.HashMap;

public class ClubData {
    // Database to hold club objects and related information
    static HashMap<String, Club> clubs = new HashMap<>();

    static {
        clubs.put("Vassar Outing Club", new Club("Vassar Outing Club"));
        clubs.put("Vassar College Television Club", new Club("Vassar College Television Club"));
        clubs.put("Asian Student Association", new Club("Asian Student Association"));
        clubs.put("South Asian Student Association", new Club("South Asian Student Association"));
        clubs.put("Korean Dance Organization", new Club("Korean Dance Organization"));
        clubs.put("Acapella Club", new Club("Acapella Club"));
        clubs.put("Photography Club", new Club("Photography Club"));
        clubs.put("Rugby Team", new Club("Rugby Team"));
        clubs.put("Rowing Team", new Club("Rowing Team"));
        clubs.put("Club Soccer", new Club("Club Soccer"));
    }

    // Below are the add, remove, and get for updating and retrieving information for clubs

    public static HashMap<String, Club> getData () { return clubs; }
    public static void add (String clubName, Club club) { clubs.put(clubName, club); }
    public static Club remove (String clubName) { return clubs.remove(clubName); }
    public static Club get (String clubName) { return clubs.get(clubName); }

}
