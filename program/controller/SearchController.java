package program.controller;

import program.model.utility.Search;
import program.view.SearchView;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class SearchController {

    private Scanner scanner;
    private SearchView searchView;

    public String action = "start";
    public String query = "";
    public String type = "";
    private ArrayList<String> searchResults;
    public SearchController () {
        scanner = new Scanner(System.in);
        searchView = new SearchView();
    }
    public void search (String type, String query) {
        searchResults = Search.search(type, query);
    }

    public void navigation () {
        //FLow for searching, user defines if they want to look for a club or event and then take the name to
        //look in the database
        while (true) {
            try {
                updateView(1);
                search(type, query);
                if (searchResults.size() == 0) {
                    searchView.renderNothingFound();
                    continue;
                }
                updateView(2);
                updateView(3);
                if (action.equalsIgnoreCase("quit")) break;
            } catch (InputMismatchException e) {
                break;
            }
        }
    }

    public void updateView (int phase) {
        //Changes the view of the search based on where the user is in their search process, users can quit anytime.
        if (phase == 1) {
            searchView.renderSearchInitialization();
            searchView.renderTypeCheck();
            type = scanner.nextLine();
            if (type.equalsIgnoreCase("quit")) {
                action = "quit";
                throw new InputMismatchException();
            }
            searchView.renderQueryInput();
            query = scanner.nextLine();
            if (query.equalsIgnoreCase("quit")) {
                action = "quit";
                throw new InputMismatchException();
            }
        }
        else if (phase == 2) searchView.renderSearchResults(searchResults);
        else if (phase == 3) {
            searchView.renderQueryInput();
            query = scanner.nextLine();
            if (query.equalsIgnoreCase("stop")) throw new InputMismatchException();
            else if (query.equalsIgnoreCase("quit")) {
                action = "quit";
                return;
            }
            searchView.renderInspectClubOrEvent(type, query);
        }
    }
}