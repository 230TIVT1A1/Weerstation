import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        IO.init();
        GUI.clearSegment();
        GUI.clrDisplay();

        new MenuLoop(MenuInit.start());

        // When quit, clear the entire display
        GUI.clearSegment();
        GUI.clrDisplay();
    }
}