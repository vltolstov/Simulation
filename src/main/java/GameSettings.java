import Utils.InputReader;
import Utils.Notifier;

public class GameSettings {

    private final int worldWidth;
    private final int worldHeight;
    private final static String SETTINGS_MESSAGE = "Настройка игрового мира";
    private final static String SETTINGS_WORLD_WIDTH_MESSAGE = "Введите ширину мира:";
    private final static String SETTINGS_WORLD_HEIGHT_MESSAGE = "Введите высоту мира:";

    public GameSettings() {
        Notifier.showMessage(SETTINGS_MESSAGE);

        Notifier.showMessage(SETTINGS_WORLD_WIDTH_MESSAGE);
        worldWidth = InputReader.getUserDigits();

        Notifier.showMessage(SETTINGS_WORLD_HEIGHT_MESSAGE);
        worldHeight = InputReader.getUserDigits();
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
}
