package Chapter2UsingCollections;

import java.util.function.Predicate;

import static util.UsedCollections.*;

public class _4ReusingLambdaExpressions {

    public static void main(String[] args) {
        nativeApproachUsingFilter();
        reusingLambdaAsPredicate();
    }

    public static void nativeApproachUsingFilter() {
        final long countFriendsStartN =
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        final long countComradesStartN =
                comrades.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        final long countEditorsStartN =
                editors.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        printCounters(countFriendsStartN, countComradesStartN, countEditorsStartN);
    }

    public static void reusingLambdaAsPredicate() {
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final long countFriendsStartN =
                friends.stream()
                        .filter(startsWithN).count();
        final long countComradesStartN =
                comrades.stream()
                        .filter(startsWithN).count();
        final long countEditorsStartN =
                editors.stream()
                        .filter(startsWithN).count();
        printCounters(countFriendsStartN, countComradesStartN, countEditorsStartN);
    }

    private static void printCounters(long friends, long comrades, long editors) {
        System.out.printf("%d friends start with N" +
                        "\n%d comrades start with N" +
                        "\n%d editors start with N\n",
                friends,
                comrades,
                editors
        );
    }
}
