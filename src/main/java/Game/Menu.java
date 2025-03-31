package Game;

import Utils.ConsoleRenderer;
import Utils.InputReader;

public class Menu extends Thread {

    private final static String CMD_STOP = "стоп";
    private final static String CMD_PAUSE = "пауза";
    private final static String STOP_MESSAGE = "Для выхода из игры введите - " + CMD_STOP;
    private final static String PAUSE_MESSAGE = "Для паузы игры введите - " + CMD_PAUSE;
    private GameState gameState;

    public Menu() {
        showMenuMessages();
    }

    public void showMenuMessages() {
        ConsoleRenderer.renderMessage(STOP_MESSAGE);
        ConsoleRenderer.renderMessage(PAUSE_MESSAGE);
    }

    @Override
    public void run() {
        selectGameState();
    }

    public GameState selectGameState() {

        String command = InputReader.getUserCommand();

        if (command.equals(CMD_STOP)) {
            setGameState(GameState.STOP);
        } else if (command.equals(CMD_PAUSE)) {
            setGameState(GameState.PAUSE);
        } else {
            ConsoleRenderer.renderErrorMessage();
        }

        return gameState;
    }

    public void setGameState(GameState state) {
        gameState = state;
    }

    public GameState getGameState() {
        return gameState;
    }
}

