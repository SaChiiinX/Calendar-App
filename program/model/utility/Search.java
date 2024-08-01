package program.model.utility;
import program.model.framework.ClubData;
import program.model.framework.EventData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Search {

    public static ArrayList<String> search (String type, String query) {
        //Search for clubs and events, maybe users depending on privacy
        // Looks for names as keys and then retrieves from database if possible
        //user search will be implemented in the future
        Set<String> target = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        if (type.equalsIgnoreCase("Club")) target = ClubData.getData().keySet();
        else if (type.equalsIgnoreCase("Event")) target = EventData.getData().keySet();
        for (String key: target)
            if (key.contains(query)) res.add(key);
        return res;
    }

}