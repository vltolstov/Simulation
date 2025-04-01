package Game;

import Utils.ConsoleRenderer;
import Utils.InputReader;

public class Menu extends Thread {

    private final static int CMD_RUN_ONE_LOOP = 1;
    private final static int CMD_PLAY = 2;
    private final static int CMD_PAUSE = 3;
    private final static int CMD_STOP = 4;


    private final static String TITLE_MESSAGE = "Command:";
    private final static String ONE_LOOP_MESSAGE = "Run one game loop: " + CMD_RUN_ONE_LOOP;
    private final static String PLAY_MESSAGE = "Play: " + CMD_PLAY;
    private final static String PAUSE_MESSAGE = "Pause: " + CMD_PAUSE;
    private final static String STOP_MESSAGE = "Stop: " + CMD_STOP;

    private GameState gameState;

    public Menu() {
        showMenuMessages();
    }

    public void showMenuMessages() {
        ConsoleRenderer.renderMessage(TITLE_MESSAGE);
        ConsoleRenderer.renderMessage(ONE_LOOP_MESSAGE);
        ConsoleRenderer.renderMessage(PLAY_MESSAGE);
        ConsoleRenderer.renderMessage(PAUSE_MESSAGE);
    }

    @Override
    public void run() {
        selectGameState();
    }

    public void selectGameState() {

        while (gameState != GameState.STOP) {
            Integer command = InputReader.getUserDigits();

            switch (command) {
                case CMD_RUN_ONE_LOOP -> setGameState(GameState.ONGOING);
                case CMD_PLAY -> setGameState(GameState.ONGOING);
                case CMD_PAUSE -> setGameState(GameState.PAUSE);
                case CMD_STOP -> setGameState(GameState.STOP);
                default -> ConsoleRenderer.renderErrorMessage();
            }
        }
    }

    public void setGameState(GameState state) {
        gameState = state;
    }

    public GameState getGameState() {
        return gameState;
    }
}

