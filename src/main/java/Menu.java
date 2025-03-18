public class Menu {

    private final static String CMD_START = "старт";
    private final static String CMD_STOP = "стоп";
    private final static String START_MESSAGE = "Для запуска введите - " + CMD_START;
    private final static String STOP_MESSAGE = "Для выхода из игры введите - " + CMD_STOP;
    private final static String WRONG_COMMAND_MESSAGE = "Не верная команда. Попробуйте еще раз.";
    private static boolean STATE_MENU = true;

    public Menu() {
        showMenuMessages();
    }

    private void showMenuMessages() {
        Notifier.showMessage(START_MESSAGE);
        Notifier.showMessage(STOP_MESSAGE);
    }

    public void setGameState() {
        do{
            String command = CommandReader.getUserInput();

            if (command.equals(CMD_START)){
                STATE_MENU = false;
            } else if (command.equals(CMD_STOP)){
                STATE_MENU = false;
                // стейт игры тоже false
            } else {
                Notifier.showMessage(WRONG_COMMAND_MESSAGE);
            }

        } while (STATE_MENU);
    }
}
