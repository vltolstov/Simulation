package Utils;

public class ConsoleRenderer {

    private static final String ERROR_MESSAGE = "Input error. Try again.";

    public static void renderMessage(String message) {
        System.out.println(message);
    }

    public static void renderErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }
}