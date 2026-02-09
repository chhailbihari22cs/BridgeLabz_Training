import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {
        int limit = 20;

        Function<String, Integer> getLength = msg -> msg.length();

        String message = "Hello Java Functional Interface";

        int length = getLength.apply(message);

        if (length > limit) {
            System.out.println("Message exceeds character limit");
        } else {
            System.out.println("Message within character limit");
        }

    }

}