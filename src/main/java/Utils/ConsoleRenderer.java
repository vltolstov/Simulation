package Utils;

public class ConsoleRenderer {

    private static final String ERROR_MESSAGE = "Ошибка ввода. Попробуйте еще раз";

    public static void renderMessage(String message) {
        System.out.println(message);
    }

    public static void renderErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }

    public static void clean() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}