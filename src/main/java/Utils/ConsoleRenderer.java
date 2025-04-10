package Utils;

public class ConsoleRenderer {

    private static final String ERROR_MESSAGE = "Ошибка ввода. Попробуйте еще раз";

    public static void renderMessage(String message) {
        System.out.println(message);
    }

    public static void renderErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }
}