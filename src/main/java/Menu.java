public class Menu {

    private final static String CMD_STOP = "стоп";
    private final static String CMD_PAUSE = "пауза";
    private final static String STOP_MESSAGE = "Для выхода из игры введите - " + CMD_STOP;
    private final static String PAUSE_MESSAGE = "Для паузы игры введите - " + CMD_PAUSE;
    private final static String WRONG_COMMAND_MESSAGE = "Неверная команда. Попробуйте еще раз.";

    public Menu() {
        showMenuMessages();
    }

    private void showMenuMessages() {
        Notifier.showMessage(STOP_MESSAGE);
        Notifier.showMessage(PAUSE_MESSAGE);
    }

    public GameState selectGameState(GameState state) {

        String command = CommandReader.getUserInput();

        if(command.equals(CMD_STOP)) {
            return state = GameState.STOP;
        } else if (command.equals(CMD_PAUSE)) {
            return state = GameState.PAUSE;
        } else {
            Notifier.showMessage(WRONG_COMMAND_MESSAGE);
        }

        return state;
    }
}

