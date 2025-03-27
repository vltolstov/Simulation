package Game;

import Utils.ConsoleRenderer;
import Utils.InputReader;

public class Menu {

    private final static String CMD_STOP = "стоп";
    private final static String CMD_PAUSE = "пауза";
    private final static String STOP_MESSAGE = "Для выхода из игры введите - " + CMD_STOP;
    private final static String PAUSE_MESSAGE = "Для паузы игры введите - " + CMD_PAUSE;

    public Menu() {
        showMenuMessages();
    }

    private void showMenuMessages() {
        ConsoleRenderer.renderMessage(STOP_MESSAGE);
        ConsoleRenderer.renderMessage(PAUSE_MESSAGE);
    }

    public GameState selectGameState(GameState state) {

        String command = InputReader.getUserCommand();

        if (command.equals(CMD_STOP)) {
            return GameAction.stopSimulation();
        } else if (command.equals(CMD_PAUSE)) {
            return GameAction.pauseSimulation();
        } else {
            ConsoleRenderer.renderErrorMessage();
        }

        return state;
    }
}

