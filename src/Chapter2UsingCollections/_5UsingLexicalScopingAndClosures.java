package Chapter2UsingCollections;


import java.util.function.Function;
import java.util.function.Predicate;

import static util.UsedCollections.friends;

public class _5UsingLexicalScopingAndClosures {

    public static void main(String[] args) {
        duplicationInLambdaExpressions();
        removingDuplicationWithLexicalScoping();
        lexicalWithNarrowScope();
    }

    public static void duplicationInLambdaExpressions() {

        final Predicate<String> startWithN = name -> name.startsWith("N");
        final Predicate<String> startWithB = name -> name.startsWith("B");

        final long countFriendsStartN =
                friends.stream()
                        .filter(startWithN).count();

        final long countFriendsStartB =
                friends.stream()
                        .filter(startWithB).count();

        printFinded(countFriendsStartN, countFriendsStartB);
    }

    public static void removingDuplicationWithLexicalScoping() {

        final long countFriendsStartN =
                friends.stream()
                        .filter(checkIfStartsWith("N")).count();

        final long countFriendsStartB =
                friends.stream()
                        .filter(checkIfStartsWith("B")).count();

        printFinded(countFriendsStartN, countFriendsStartB);
    }

    private static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }


    /**
     * Refactoring to narrow the scope
     */

    public static void lexicalWithNarrowScope() {
        final long countFriendsStartN =
                friends.stream()
                        .filter(checkIfStartsWithNarrowScope.apply("N"))
                        .count();
        final long countFriendsStartB =
                friends.stream()
                        .filter(checkIfStartsWithNarrowScope.apply("B"))
                        .count();
        printFinded(countFriendsStartN, countFriendsStartB);


        final long countFriendsStartNLambda =
                friends.stream()
                        .filter(checkIfStartsWithNarrowScopeLambdaExpression.apply("N"))
                        .count();
        final long countFriendsStartBLambda =
                friends.stream()
                        .filter(checkIfStartsWithNarrowScopeLambdaExpression.apply("B"))
                        .count();
        printFinded(countFriendsStartNLambda, countFriendsStartBLambda);


        final long countFriendsStartNLambdaInferTypes =
                friends.stream()
                        .filter(checkIfStartsWithNarrowScopeLambdaExpressionInferTypes.apply("N"))
                        .count();
        final long countFriendsStartBLambdaInferTypes =
                friends.stream()
                        .filter(checkIfStartsWithNarrowScopeLambdaExpressionInferTypes.apply("B"))
                        .count();
        printFinded(countFriendsStartNLambdaInferTypes, countFriendsStartBLambdaInferTypes);
    }

    final static Function<String, Predicate<String>> checkIfStartsWithNarrowScope =
            (String letter) -> {
                Predicate<String> checkStartWith =
                        (String name) -> name.startsWith(letter);
                return checkStartWith;
            };

    final static Function<String, Predicate<String>> checkIfStartsWithNarrowScopeLambdaExpression =
            (String letter) -> (String name) -> name.startsWith(letter);

    final static Function<String, Predicate<String>> checkIfStartsWithNarrowScopeLambdaExpressionInferTypes =
            letter -> name -> name.startsWith(letter);


    private static void printFinded(long startN, long startB) {
        System.out.printf("%d friends start with N"
                        + "\n%d friends start with B\n",
                startN,
                startB
        );
    }

}
