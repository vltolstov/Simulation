package Game;

import Utils.ConsoleRenderer;
import Utils.InputReader;

public class Menu {

    private final static int CMD_RUN_ONE_LOOP = 1;
    private final static int CMD_PLAY = 2;
    private final static int CMD_PAUSE = 3;
    private final static int CMD_STOP = 4;


    private final static String TITLE_MESSAGE = "Command:";
    private final static String ONE_LOOP_MESSAGE = CMD_RUN_ONE_LOOP + " - Run one game loop";
    private final static String PLAY_MESSAGE = CMD_PLAY + " - Play";
    private final static String PAUSE_MESSAGE = CMD_PAUSE + " - Pause";
    private final static String STOP_MESSAGE = CMD_STOP + " - Stop";

    private GameState gameState;

    public Menu() {
        gameState = GameState.ONGOING;
    }

    public void selectGameState(Object mutex) {

        ConsoleRenderer.renderMessage(TITLE_MESSAGE);

        Integer command = InputReader.getUserDigits();

        if (gameState == GameState.PAUSE) {
            ConsoleRenderer.renderMessage(ONE_LOOP_MESSAGE);
            ConsoleRenderer.renderMessage(PLAY_MESSAGE);

            switch (command) {
                case CMD_RUN_ONE_LOOP -> setGameState(GameState.ONGOING);
                case CMD_PLAY -> setGameState(GameState.ONGOING);
            }

            mutex.notify();

        } else if (gameState == GameState.ONGOING) {
            ConsoleRenderer.renderMessage(PAUSE_MESSAGE);

            switch (command) {
                case CMD_PAUSE -> setGameState(GameState.PAUSE);
            }
        }

        ConsoleRenderer.renderMessage(STOP_MESSAGE);

        switch (command) {
            case CMD_STOP -> setGameState(GameState.STOP);
            default -> ConsoleRenderer.renderErrorMessage();
        }
    }

    public void setGameState(GameState state) {
        gameState = state;
    }

    public GameState getGameState() {
        return gameState;
    }
}

