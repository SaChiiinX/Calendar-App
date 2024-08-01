package program.model.framework;

import program.model.user.User;

import java.util.HashMap;


public class UserData {
    static HashMap<String, User> users = new HashMap<>();

    //Database containing all user objects and information

    static {
        users.put("Alexander Wilson", new User("Alexander Wilson"));
        users.put("Emily Thompson", new User("Emily Thompson"));
        users.put("Ethan Lee", new User("Ethan Lee"));
        users.put("Chloe Davis", new User("Chloe Davis"));
        users.put("Benjamin Foster", new User("Benjamin Foster"));
        users.put("Lily Nguyen", new User("Lily Nguyen"));
        users.put("William Martinez", new User("William Martinez"));
        users.put("Ava Patel", new User("Ava Patel"));
        users.put("Daniel Brown", new User("Daniel Brown"));
        users.put("Sophia Phillips", new User("Sophia Phillips"));
        users.put("Jacob Kim", new User("Jacob Kim"));
        users.put("Mia Singh", new User("Mia Singh"));
        users.put("Ryan Hernandez", new User("Ryan Hernandez"));
        users.put("Grace Wong", new User("Grace Wong"));
        users.put("Michael Chen", new User("Michael Chen"));
        users.put("Olivia Taylor", new User("Olivia Taylor"));
        users.put("Matthew Rodriguez", new User("Matthew Rodriguez"));
        users.put("Emma Hernandez", new User("Emma Hernandez"));
        users.put("Joshua Scott", new User("Joshua Scott"));
        users.put("Isabella Lewis", new User("Isabella Lewis"));
        users.put("Nicholas Baker", new User("Nicholas Baker"));
        users.put("Harper Garcia", new User("Harper Garcia"));
        users.put("Christopher Wright", new User("Christopher Wright"));
        users.put("Amelia Adams", new User("Amelia Adams"));
        users.put("Andrew Nelson", new User("Andrew Nelson"));
        users.put("Elizabeth Reyes", new User("Elizabeth Reyes"));
        users.put("David Cooper", new User("David Cooper"));
        users.put("Abigail Hall", new User("Abigail Hall"));
        users.put("Tyler Mitchell", new User("Tyler Mitchell"));
        users.put("Madison Myers", new User("Madison Myers"));
    }

    // Add, remove, and get methods relating to user objects and their information

    public static HashMap<String, User> getData () { return users; }
    public static void add (String name, User user) { users.put(name, user); }
    public User remove (String name) { return users.remove(name);}
    public User get(String name) { return users.get(name); }

}
