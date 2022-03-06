package Chapter2UsingCollections;

import java.util.stream.Collectors;

import static util.UsedCollections.friends;

public class _8JoiningElements {

    public static void main(String[] args) {
        printListHabitualWay();
        printListHabitualWayStopingBeforeLastComma();
        printListSimpleOneLine();
        printListSimpleOneLineToUpperCase();
    }

    static void printListHabitualWay() {
        for (String name : friends) {
            System.out.print(name + ", ");
        }
        System.out.println();
    }

    static void printListHabitualWayStopingBeforeLastComma() {
        for (int i = 0; i < friends.size() - 1; i++) {
            System.out.print(friends.get(i) + ", ");
        }
        if (friends.size() > 0)
            System.out.println(friends.get(friends.size() - 1));
    }

    static void printListSimpleOneLine() {
        System.out.println(String.join(", ", friends));
    }

    static void printListSimpleOneLineToUpperCase() {
        System.out.println(
                friends.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", "))
        );
    }
}

