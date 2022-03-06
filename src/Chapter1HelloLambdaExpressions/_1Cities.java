package Chapter1HelloLambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1Cities {

    public static void main(String[] args) {
        theHabitualWay();//imperative, low level
        aBetterWay();//declarative, high level
    }

    public static void theHabitualWay() {
        boolean found = false;
        List<String> cities = new ArrayList();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("San Francisco");
        cities.add("Springfield");
        for (String city : cities) {
            if (city.equals("Chicago")) {
                found = true;
                break;
            }
        }
        System.out.println("Found Chicago?: " + found);
    }

    public static void aBetterWay() {
        List<String> cities = Arrays.asList("New York", "Los Angeles", "Chicago", "San Francisco", "Springfield");
        System.out.println("Found Chicago?: " + cities.contains("Chicago"));
    }

    /**
     * Beyond Simple Cases
     * That was simple - the declarative function to check if an element is present
     * in a collection has been around in Java for a very long tim. Now imagine not
     * having to write imperative code for more advanced operations, like parsing
     * files, working with databases, making calls to web services, concurrent pro-
     * gramming, and so on. Java now makes it possible to write concise, elegant,
     * less error-prone, not just for simple cases, but throughout our applications.
     * */
}
