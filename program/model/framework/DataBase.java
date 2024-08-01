//package program.model.framework;
//
//import program.model.organizations.Club;
//import program.model.organizations.Event;
//import program.model.user.user;
//
//import java.util.*;
//
//public class DataBase {
//
//    private static DataBase data = null;
//    private DataBase () {};
//
//    public static DataBase getDataBase () {
//        if (data == null)
//            data = new DataBase();
//        return data;
//    }
//    public HashMap<String, user> users = new HashMap<>();
//    public HashMap<String, Club> clubs = new HashMap<>();
//    private HashMap<String, Event> events = new HashMap<>();
//
//    {
//        users.put("Alexander Wilson", new user("Alexander Wilson"));
//        users.put("Emily Thompson", new user("Emily Thompson"));
//        users.put("Ethan Lee", new user("Ethan Lee"));
//        users.put("Chloe Davis", new user("Chloe Davis"));
//        users.put("Benjamin Foster", new user("Benjamin Foster"));
//        users.put("Lily Nguyen", new user("Lily Nguyen"));
//        users.put("William Martinez", new user("William Martinez"));
//        users.put("Ava Patel", new user("Ava Patel"));
//        users.put("Daniel Brown", new user("Daniel Brown"));
//        users.put("Sophia Phillips", new user("Sophia Phillips"));
//        users.put("Jacob Kim", new user("Jacob Kim"));
//        users.put("Mia Singh", new user("Mia Singh"));
//        users.put("Ryan Hernandez", new user("Ryan Hernandez"));
//        users.put("Grace Wong", new user("Grace Wong"));
//        users.put("Michael Chen", new user("Michael Chen"));
//        users.put("Olivia Taylor", new user("Olivia Taylor"));
//        users.put("Matthew Rodriguez", new user("Matthew Rodriguez"));
//        users.put("Emma Hernandez", new user("Emma Hernandez"));
//        users.put("Joshua Scott", new user("Joshua Scott"));
//        users.put("Isabella Lewis", new user("Isabella Lewis"));
//        users.put("Nicholas Baker", new user("Nicholas Baker"));
//        users.put("Harper Garcia", new user("Harper Garcia"));
//        users.put("Christopher Wright", new user("Christopher Wright"));
//        users.put("Amelia Adams", new user("Amelia Adams"));
//        users.put("Andrew Nelson", new user("Andrew Nelson"));
//        users.put("Elizabeth Reyes", new user("Elizabeth Reyes"));
//        users.put("David Cooper", new user("David Cooper"));
//        users.put("Abigail Hall", new user("Abigail Hall"));
//        users.put("Tyler Mitchell", new user("Tyler Mitchell"));
//        users.put("Madison Myers", new user("Madison Myers"));
//    }
//
//    {
//        clubs.put("Vassar Outing Club", new Club("Vassar Outing Club"));
//        clubs.put("Vassar College Television Club", new Club("Vassar College Television Club"));
//        clubs.put("Asian Student Association", new Club("Asian Student Association"));
//        clubs.put("South Asian Student Association", new Club("South Asian Student Association"));
//        clubs.put("Korean Dance Organization", new Club("Korean Dance Organization"));
//        clubs.put("Acapella Club", new Club("Acapella Club"));
//        clubs.put("Photography Club", new Club("Photography Club"));
//        clubs.put("Rugby Team", new Club("Rugby Team"));
//        clubs.put("Rowing Team", new Club("Rowing Team"));
//        clubs.put("Club Soccer", new Club("Club Soccer"));
//
//        clubs.get("Vassar Outing Club").setRegular("6:30 PM", "Jewett Lobby", "Wednesday", 30);
//        clubs.get("Vassar College Television Club").setRegular("5:30 PM", "Chicago Hall", "Tuesday", 60);
//        clubs.get("Asian Student Association").setRegular("6:30 PM", "ALANA Center", "Thursday", 90);
//        clubs.get("South Asian Student Association").setRegular("8:00 PM", "Pratt House", "Wednesday", 60);
//        clubs.get("Korean Dance Organization").setRegular("4:30 PM", "Kenyon Hall", "Monday", 120);
//        clubs.get("Acapella Club").setRegular("9:30 PM", "Rocky Hall", "Friday", 75);
//        clubs.get("Photography Club").setRegular("3:45 PM", "Raymond Parlor", "Sunday", 60);
//        clubs.get("Rugby Team").setRegular("6:30 PM", "Ballentine Field", "Wednesday", 120);
//        clubs.get("Rowing Team").setRegular("5:00 AM", "Athletics and Fitness Center", "Monday", 150);
//        clubs.get("Club Soccer").setRegular("4:00 PM", "Josselyn Field", "Saturday", 120);
//
//        Random rand = new Random();
//        List<String> userKeyList = new ArrayList<>(users.keySet());
//        for (Map.Entry<String, Club> club: clubs.entrySet() ) {
//            for (int i = 1; i <= 10; i++) {
//                int random = rand.nextInt(30);
//                club.getValue().addMem(users.get(userKeyList.get(random)));
//            }
//        }
//
//    }
//
//    public void add (int type, NamedObject data) throws InputMismatchException {
//        switch (type) {
//            case (1):
//                if (data instanceof user) users.put(data.name, (user) data);
//                else throw new InputMismatchException();
//                break;
//            case (2):
//                if (data instanceof Club) clubs.put(data.name, (Club) data);
//                else throw new InputMismatchException();
//                break;
//            case (3):
//                if (data instanceof Event) events.put(data.name, (Event) data);
//                else throw new InputMismatchException();
//                break;
//        }
//    }
////
////    public static void remove (int type, NamedObject data) throws InputMismatchException {
////        switch (type) {
////            case (1):
////                if (data instanceof user) users.remove(data.name, data);
////                else throw new InputMismatchException();
////                break;
////            case (2):
////                if (data instanceof user) clubs.remove(data.name, data);
////                else throw new InputMismatchException();
////                break;
////            case (3):
////                if (data instanceof user) events.remove(data.name, data);
////                else throw new InputMismatchException();
////                break;
////        }
////    }
//}
