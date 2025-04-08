package Utils;

import java.util.Scanner;

public class InputReader {

    private static Scanner scanner = new Scanner(System.in);

    public static int getUserCommands() {

        while (!scanner.hasNextInt()) {
            ConsoleRenderer.renderErrorMessage();
            scanner.next();
        }

        return scanner.nextInt();
    }
}
