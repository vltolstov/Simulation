import java.util.Scanner;

public class CommandReader {

    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {

        return scanner.next().toLowerCase();

    }
}
