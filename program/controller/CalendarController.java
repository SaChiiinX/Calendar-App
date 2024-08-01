package program.controller;

import program.model.framework.EventData;
import program.model.organizations.Event;
import program.model.user.User;
import program.view.CalendarView;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CalendarController {
    private final User user;
    //the person using the controller
    private final CalendarView view;
    private String date = LocalDate.now().toString();
    //Sets date to the day today.
    public String action = "day";
    // this prints a view of the day, month, or year.
    private final Scanner scanner = new Scanner(System.in);


    public CalendarController (User user) {
        this.user = user;
        this.view = new CalendarView();
    }

    public void addEvent (String event, boolean custom) {
        //Adding event, users are able to add custom events of their own, but implementation will be for the future.
        //The custom boolean determines if the event added is a user's own event or a pre defined event belong to the school or club.
        if (!custom) {
            user.addOrRemove(EventData.get(event), true);
            view.renderAddEvent(6);
            return;
        }
        try {
            String[] info = new String[5];
            for (int i = 1; i < 6; i++) {
                view.renderAddEvent(i);
                info[i - 1] = scanner.nextLine();
                if (info[i - 1].equalsIgnoreCase("quit")) throw new InputMismatchException();
            }
            Event customEvent = new Event(info[0], info[1], info[2], info[3], info[4]);
            EventData.add(customEvent.name, customEvent);
            user.addOrRemove(customEvent, true);
            view.renderAddEvent(6);
        } catch (Exception e) {
            view.renderAddEvent(7);
        }

    }

    public void removeEvent (String event) {
        // Remove an event from the users pool of events.
        if (user.info2.contains(event)) {
            view.renderRemoveEvent(1);
            String name = scanner.nextLine();
            user.addOrRemove(EventData.get(name), false);
        } else {
            view.renderRemoveEvent(3);
            throw new InputMismatchException();
        }
    }

    public void changeMonth () throws IndexOutOfBoundsException {
        // Change the month we are viewing
        view.renderInputDate(2);
        int month = scanner.nextInt();
        scanner.nextLine();
        if (month < 1 || month > 12) throw new IndexOutOfBoundsException();
        StringBuilder res = new StringBuilder();
        res.append(date);
        if (month > 10) {
            String temp1 = "" + (month / 10);
            res.setCharAt(5, temp1.charAt(0));
        } else res.setCharAt(5, '0');
        String temp2 = "" + (month % 10);
        res.setCharAt(6, temp2.charAt(0));
        date = res.toString();
    }

    public void changeDay () throws IndexOutOfBoundsException {
        //Change the day we are viewing
        view.renderInputDate(1);
        int day = scanner.nextInt();
        scanner.nextLine();
        int month = Integer.parseInt(date.substring(5, 7));
        if (day < 1 || day > user.calendar.year.months[month].days.length) throw new IndexOutOfBoundsException();
        StringBuilder res = new StringBuilder();
        res.append(date);
        if (day > 10) {
            String temp1 = "" + (day / 10);
            res.setCharAt(8, temp1.charAt(0));
        } else res.setCharAt(8, '0');
        String temp2 = "" + (day % 10);
        res.setCharAt(9, temp2.charAt(0));
        date = res.toString();
    }

    public void navigation () {
        //This is the logic for using the calendar, users are choose between the three views and let the controller
        //know if they are trying to add or remove an event. On quit, will halt the flow.
        String pastState = action;
        while (true) {
            try {
                view.renderInputDate(4);
                action = scanner.nextLine();
                if (action.equalsIgnoreCase("month")) {
                    if (pastState.equalsIgnoreCase("day")) updateViewMode("Month");
                    else if (pastState.equalsIgnoreCase("year")) {
                        changeMonth();
                        updateViewMode("month");
                    }
                    else throw new InputMismatchException();
                }
                else if (action.equalsIgnoreCase("day")) {
                    if (pastState.equalsIgnoreCase("year")) changeMonth();
                    changeDay();
                    updateViewMode("day");
                }
                else if (action.equalsIgnoreCase("year")) updateViewMode("year");
                else if (action.equalsIgnoreCase("add")) {
                    view.renderAddEvent(1);
                    String event = scanner.nextLine();
                    if (EventData.getData().containsKey(event)) addEvent(event, false);
                    else throw new InputMismatchException();
                }
                else if (action.equalsIgnoreCase("remove")) {
                    view.renderRemoveEvent(1);
                    String event = scanner.nextLine();
                    view.renderRemoveEvent(2);
                }
                else if (action.equalsIgnoreCase("stop")) action = pastState;
                else if (action.equalsIgnoreCase("quit")) action = "quit";
                else {
                    scanner.nextLine();
                    throw new InputMismatchException();
                }
                break;
            } catch (Exception e) { view.renderInputDate(3); }
        }
    }

    public void updateViewMode (String viewMode) {
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        if (viewMode.equalsIgnoreCase("Day")) view.renderDayView(user.calendar.getDay(day, month), user.calendar.getMonth(month));
        else if (viewMode.equalsIgnoreCase("Month")) view.renderMonthView(user.calendar.getMonth(month));
        else if (viewMode.equalsIgnoreCase("Year")) view.renderYearView(user.calendar.getYear());
        action = viewMode;
    }

}

