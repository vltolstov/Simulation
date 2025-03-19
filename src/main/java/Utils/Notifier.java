package Utils;

public class Notifier {

    private static final String ERROR_MESSAGE = "Ошибка ввода. Попробуйте еще раз";

    public static void showMessage(String message){
        System.out.println(message);
    }

    public static void showErrorMessage(){
        System.out.println(ERROR_MESSAGE);
    }
}