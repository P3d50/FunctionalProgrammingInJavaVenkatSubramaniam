package util;

import java.util.Arrays;
import java.util.List;

public class UsedCollections {

    public final static List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public final static List<String> comrades =
            Arrays.asList("Kate", "ken", "Nick", "Paula", "Zach");

    public final static List<String> editors =
            Arrays.asList("Brian", "Jackie", "John", "Mike");


    public final static List<Person> people = Arrays.asList(
            new Person("Jhon", 20),
            new Person("Sara", 21),
            new Person("Jane",21),
            new Person("Greg",35)
    );
}
