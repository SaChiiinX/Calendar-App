package program.controller;

import program.view.HomeView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeController {
    //Controller for the 'home' page
    private HomeView homeView;
    private Scanner scanner;
    public String action = "";

    public HomeController () {
        homeView = new HomeView();
        scanner = new Scanner(System.in);
    }

    public boolean viewControl () throws InputMismatchException {
        //Determines if the user wants to search or view calendar
        return action.equalsIgnoreCase("calendar") || action.equalsIgnoreCase("c");
    }

    public void chooseAction () {
        //user chooses their action through the scanner;
        homeView.renderHome();
        action = scanner.nextLine();
    }
}