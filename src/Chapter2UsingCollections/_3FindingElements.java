package Chapter2UsingCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static util.UsedCollections.friends;

public class _3FindingElements {

    public static void main(String[] args) {
        theHabitualWay();
        aBetterWayUsingFilter();
    }

    public static void theHabitualWay() {
        final List<String> startsWithN = new ArrayList<>();
        for (String name : friends) {
            if (name.startsWith("N")) {
                startsWithN.add(name);
            }
        }
        System.out.println(startsWithN);
    }

    public static void aBetterWayUsingFilter() {
        final List<String> startsWithN =
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());
        System.out.printf("Found %d names%n", startsWithN.size());
    }

}
