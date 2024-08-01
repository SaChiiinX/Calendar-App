package program.view;

import program.model.Calendar.Day;
import program.model.Calendar.Month;
import program.model.Calendar.Year;

public class CalendarView {

    public void renderInputDate (int phase) {
        if (phase == 1) System.out.println("Type the day:");
        else if (phase == 2) System.out.println("Type the month: ");
        else if (phase == 3) System.out.println("Wrong input, try again.");
        else if (phase == 4) System.out.println("Input your action: ");
    }

    public void renderYearView (Year year) {
        System.out.println("You are currently viewing the year. To view a specific month, type the corresponding month number (1 - January)...(12 - December). To view a specific day, type the same month number followed by the day of the month");
        System.out.println("\n");
        System.out.println(year);
    }
    public void renderMonthView (Month month) {
        System.out.println("You are currently viewing the month: " + month.shortened);
        System.out.println("To view a specific day, type the day of month. To go back to the year view, type \"year\".");
        System.out.println(month);
    }
    public void renderDayView(Day day, Month month) {
        System.out.println("You are currently viewing " + month.shortened + " " + day.day + ".");
        System.out.println("To go back to the month view, type \"month\". To go back to year view, type \"year\".");
        System.out.println("To add an event, type \"add\". To remove prexisting events, type \"remove\".\n");
        System.out.println("Here is what you have planned today.\n");
        System.out.println(day);
    }

    public void renderAddEvent (int phase) {
        if (phase == 1) System.out.println("Event name:");
        else if (phase == 2) System.out.println("Start date (yyyy-mm-dd): ");
        else if (phase == 3) System.out.println("Start time (hh-mm AM/PM): ");
        else if (phase == 4) System.out.println("End time (hh-mm AM/PM): ");
        else if (phase == 5) System.out.println("Location: ");
        else if (phase == 7) System.out.println("Cancelled");
        else System.out.println("Success!");
    }

    public void renderRemoveEvent (int phase) {
        if (phase == 1) System.out.println("Type in the name of the event you would like to remove");
        else if (phase == 2) System.out.println("Success!");
        else if (phase == 3) System.out.println("Event not found, try searching again.");
    }
}