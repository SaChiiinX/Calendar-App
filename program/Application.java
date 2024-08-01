package program;

import program.controller.CalendarController;
import program.controller.HomeController;
import program.controller.SearchController;
import program.model.user.User;

public class Application {
    public static void  {
        User steven = new User("Steven");
        CalendarController calendarController = new CalendarController(steven);
        calendarController.addEvent("Lunar New Year Celebration", false);
        calendarController.addEvent("Kpop Showcase", false);
        calendarController.addEvent("Early Bird Pilates", false);

        SearchController searchController = new SearchController();
        HomeController homeController = new HomeController();
        while (true) {
            homeController.chooseAction();
            searchController.action = "";
            if (homeController.viewControl()) {
                calendarController.updateViewMode("day");
                while (!calendarController.action.equalsIgnoreCase("quit"))
                    calendarController.navigation();
            } else {
                while (!searchController.action.equalsIgnoreCase("quit")) {
                    searchController.navigation();
                }
            }
        }
        }

}
