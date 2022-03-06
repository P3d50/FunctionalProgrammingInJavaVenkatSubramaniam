package Chapter2UsingCollections;

import java.util.ArrayList;
import java.util.List;

import static util.UsedCollections.friends;


public class _2TransformingAList {

    public static void main(String[] args) {
        theHabitualWay();
        aBetterlWayWithInternalIterator();
        aBetterlWayWithLambdaExpressions();
        aBetterlWayTypeInDiffersOfTypeOut();
        aBetterlWayWithLambdaExpressionsMethodReference();
        aBetterlWayTypeInDiffersOfTypeOutMethodReference();
    }

    public static void theHabitualWay() {
        List<String> uppercaseNames = new ArrayList<>();
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);
    }

    public static void aBetterlWayWithInternalIterator() {
        final List<String> uppercaseNames = new ArrayList<>();
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);
    }

    public static void aBetterlWayWithLambdaExpressions() {
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    public static void aBetterlWayWithLambdaExpressionsMethodReference() {
        System.out.println();
        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    public static void aBetterlWayTypeInDiffersOfTypeOut() {
        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));
    }

    public static void aBetterlWayTypeInDiffersOfTypeOutMethodReference() {
        friends.stream()
                .map(String::length)
                .forEach(count -> System.out.print(count + " "));
    }

}
