package Chapter3StringsComparatorsAndFilters.comparators;

import util.Person;

import java.util.Comparator;
import java.util.stream.Collectors;

import static util.UsedCollections.people;
import static util.UsedMethods.printPeople;

public class _3ReusingAComparator {

    public static void main(String[] args) {

        printPeople("Sorted in descending order of age:",
                people.stream()
                        .sorted((person1, person2) -> person2.ageDiference(person1))
                        .collect(Collectors.toList())
        );

        printPeople("Sorted in ascending order of age, Comparator",
                people.stream()
                        .sorted(compareAscending)
                        .collect(Collectors.toList())
        );

        printPeople("Sorted in descending order of age, Comparator.reversed()",
                people.stream()
                        .sorted(compareDescending)
                        .collect(Collectors.toList())
        );

        printPeople("Sorted in ascending order of name",
                people.stream()
                        .sorted((person1,person2)->
                                person1.getName().compareTo(person2.getName()))
                        .collect(Collectors.toList())
        );

        people.stream()
                .min(Person::ageDiference)
                .ifPresent(youngest -> System.out.println("Youngest: "+youngest));

        people.stream()
                .max(Person::ageDiference)
                .ifPresent(eldest -> System.out.println("Eldest: "+eldest));

    }


    static Comparator<Person> compareAscending = (person1, person2) ->
            person1.ageDiference(person2);

    static Comparator<Person> compareDescending = compareAscending.reversed();

}
