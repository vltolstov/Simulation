import Utils.ConsoleRenderer;
import Utils.InputReader;

public class Menu extends Thread {

    private Simulation simulation;

    private final static int CMD_RUN_ONE_LOOP = 1;
    private final static int CMD_PLAY = 2;
    private final static int CMD_PAUSE = 3;
    private final static int CMD_STOP = 4;

    private final static String TITLE_MESSAGE = "Command:";
    private final static String ONE_LOOP_MESSAGE = CMD_RUN_ONE_LOOP + " - Run one game loop";
    private final static String PLAY_MESSAGE = CMD_PLAY + " - Play";
    private final static String PAUSE_MESSAGE = CMD_PAUSE + " - Pause";
    private final static String STOP_MESSAGE = CMD_STOP + " - Stop";

    public Menu(Simulation simulation) {
        this.simulation = simulation;
    }

    public static void showMenu() {
        ConsoleRenderer.renderMessage(TITLE_MESSAGE);
        ConsoleRenderer.renderMessage(ONE_LOOP_MESSAGE);
        ConsoleRenderer.renderMessage(PLAY_MESSAGE);
        ConsoleRenderer.renderMessage(PAUSE_MESSAGE);
        ConsoleRenderer.renderMessage(STOP_MESSAGE);
    }

    public void run() {

        while (simulation.getGameState() != GameState.STOP) {
            Integer command = InputReader.getUserCommands();

            if (command == CMD_RUN_ONE_LOOP) {
                simulation.setGameState(GameState.ONE_LOOP);
                simulation.resumeSimulation();
            } else if (command == CMD_PLAY) {
                simulation.setGameState(GameState.INFINITY_PLAY);
                simulation.resumeSimulation();
            } else if (command == CMD_PAUSE) {
                simulation.setGameState(GameState.PAUSE);
                simulation.pauseSimulation();
            } else if (command == CMD_STOP) {
                simulation.setGameState(GameState.STOP);
            } else {
                ConsoleRenderer.renderErrorMessage();
            }
        }
    }
}

