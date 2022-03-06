package Chapter2UsingCollections;

import java.util.List;
import java.util.Optional;

import static util.UsedCollections.friends;

public class _6PickingAnElement {

    public static void main(String[] args) {
        pickNameHabitualWay(friends, "N");
        pickNameLambdaWay(friends, "B");
    }

    public static void pickNameHabitualWay(final List<String> names, final String startingLetter) {

        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.println(String.format("A name starting with %s: ", startingLetter));
        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickNameLambdaWay(final List<String> names, final String startingLetter) {
        final Optional<String> foundName =
                names.stream()
                        .filter(name -> name.startsWith(startingLetter))
                        .findFirst();

        System.out.println(String.format("A name starting with %s: \n%s",
                        startingLetter, foundName.orElse("No name Found")
                )
        );
    }
}
