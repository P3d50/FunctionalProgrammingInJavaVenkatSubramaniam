package Chapter3StringsComparatorsAndFilters.strings;

public class _1IteratingAString {

    public static void main(String[] args) {
        final String str = "w00t";

        str.chars().forEach(System.out::println);

        str.chars().forEach(_1IteratingAString::printChar);

        str.chars()
                .mapToObj(ch -> Character.valueOf((char)ch))
                .forEach(System.out::println);

        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> printChar(ch));

        str.chars()
                .filter(Character::isDigit)
                .forEach(_1IteratingAString::printChar);
        /**
         * methdd refetence call instance or static methods but
         * if we write Double::toString to convert a instance of
         * Double to a String, the compiler would get confused whether to
         * use the public String toString() instance method or the static
         * method public static String toString(double value), both from
         * the double class, in this case we simply switch back to using
         * the appropriate lambda-expression version to move on.
         * */
    }

    private static void printChar(int aChar) {
        System.out.println((char) (aChar));
    }

}
