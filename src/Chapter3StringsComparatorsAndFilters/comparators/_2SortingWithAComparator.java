package Chapter3StringsComparatorsAndFilters.comparators;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import util.Person;

import static util.UsedCollections.people;
import static util.UsedMethods.printPeople;

public class _2SortingWithAComparator {

    public static void main(String[] args) {
        printPeople("Sorted in ascending order of age", ascendingAge);

        printPeople("Sorted in ascending order of age, method reference", ascendingAgeMethodReference);

    }

    static List<Person> ascendingAge =
            people.stream()
                    .sorted((person1, person2) -> person1.ageDiference(person2))
                    .collect(Collectors.toList());


    static List<Person> ascendingAgeMethodReference =
            people.stream()
                    .sorted(Person::ageDiference)
                    .collect(Collectors.toList());
}
