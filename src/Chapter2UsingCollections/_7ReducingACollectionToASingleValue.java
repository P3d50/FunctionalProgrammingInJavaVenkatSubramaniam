package Chapter2UsingCollections;

import java.util.Optional;

import static util.UsedCollections.friends;

public class _7ReducingACollectionToASingleValue {

    public static void main(String[] args) {
        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(name -> name.length())
                        .sum()
        );

        final Optional<String> aLongName =
                friends.stream()
                        .reduce((name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name ->
                System.out.println(String.format("A longest name: %s", name)));

        final String steveOrLonger =
                friends.stream()
                        .reduce("Steve", (name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);
        System.out.println(steveOrLonger);
    }
}
