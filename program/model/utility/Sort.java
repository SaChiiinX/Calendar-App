package program.model.utility;
import program.model.framework.Gathering;

import java.util.*;

public class Sort {

    //Sorting for alphabetical order and numerical order based on time
    public static void nameSort (ArrayList<String> arr, Boolean reverse) {
        if (reverse) arr.sort(Collections.reverseOrder());
        else Collections.sort(arr);
    }
    public static void timeSort (ArrayList<Gathering> arr, Boolean reverse) {
        if (reverse) arr.sort(Collections.reverseOrder());
        else Collections.sort(arr);
    }

}
