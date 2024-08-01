package program.model.framework;

import program.model.organizations.Event;

import java.util.HashMap;

public class EventData {
    // Database to hold database for events
    static HashMap<String, Event> events = new HashMap<>();

    static {
        events.put("Night Market", new Event("Night Market", "06:30 PM", "09:30 PM", "10/26/2023", "", "Main Building", "Asian Student Association"));
        events.put("Mid Autumn Festival", new Event("Mid Autumn Festival", "07:00 PM", "09:00 PM","11/01/2023", "", "ALANA Center", "Asian Student Association"));
        events.put("Lunar New Year Celebration", new Event("Lunar New Year Celebration", "05:30 PM", "08:30 PM", "03/22/2023", "", "Villard Room", "Asian Student Association"));
        events.put("Kpop Showcase", new Event("Kpop Showcase", "03:30 PM", "05:15 PM", "03/22/2023", "", "Villard Room", "Korean Dance Organization"));
        events.put("Early Bird Pilates", new Event("Early Bird Pilates", "06:00 AM", "08:00 AM", "03/22/2023", "", "Athletic Field Center", "Vassar Outing Club"));
    }

    // Methods to add, remove, and get information related to events
    public static HashMap<String, Event> getData () { return events; }
    public static void add (String eventName, Event event) { events.put(eventName, event); }
    public static Event remove (String eventName) { return events.remove(eventName); }
    public static Event get (String eventName) { return events.get(eventName); }

}
