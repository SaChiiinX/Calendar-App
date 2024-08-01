package program.view;

import program.model.framework.ClubData;
import program.model.framework.EventData;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchView {

    private static Scanner scanner = new Scanner(System.in);
    public void renderSearchInitialization () { System.out.println("Would you like to search for a club or an event? Type \"event\" or \"club\"."); }
    public void renderTypeCheck () { System.out.println("Define what you would like to search (club or event):"); }
    public void renderQueryInput () { System.out.println("Enter name of club/event to search or inspect:"); }

    public void renderNothingFound () { System.out.println("Nothing found, try searching with a different term;"); }
    public void renderSearchResults (ArrayList<String> res) {
        for (String elem: res) System.out.println(elem);
    }
    public void renderInspectClubOrEvent (String type, String name) {
        if (type.equalsIgnoreCase("Club")) System.out.println(ClubData.get(name));
        else if (type.equalsIgnoreCase("Event")) System.out.println(EventData.get(name));
    }

}