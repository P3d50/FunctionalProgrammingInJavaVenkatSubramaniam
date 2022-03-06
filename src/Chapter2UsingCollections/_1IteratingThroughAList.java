package Chapter2UsingCollections;

import java.util.function.Consumer;

import static util.UsedCollections.friends;

public class _1IteratingThroughAList {


    public static void main(String[] args) {
        theHabitualWay();
        aBitMoreCivilized();
        aBetterWayInternalInteraction();
        aBetterWayWithALambdaExpression();
        aBetterWayWithALambdaExpressionMethodReference();
        aBetterWayWithALambdaExpressionWithoutType();
        aBetterWayWithALambdaExpressionWithTypeInfered();
    }

    public static void theHabitualWay() {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
    }

    public static void aBitMoreCivilized() {
        for (String name : friends) {
            System.out.println(name);
        }
    }

    public static void aBetterWayInternalInteraction() {
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });
    }

    public static void aBetterWayWithALambdaExpression() {
        friends.forEach((final String name) -> System.out.println(name));
    }

    /**
     * when we favor type inference we have to pactice extra discipline not to modify
     * the parameter, as the compiles is not there to protect us
     */
    public static void aBetterWayWithALambdaExpressionWithoutType() {
        friends.forEach((name) -> System.out.println(name));
    }

    public static void aBetterWayWithALambdaExpressionWithTypeInfered() {
        friends.forEach(name -> System.out.println(name));
    }

    public static void aBetterWayWithALambdaExpressionMethodReference() {
        friends.forEach(System.out::println);
    }
}
