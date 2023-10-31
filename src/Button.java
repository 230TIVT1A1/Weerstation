public class Button {

    private static boolean selectButton;
    private static boolean previousButton;
    private static boolean nextButton;
    private static boolean selectButtonLast;
    private static boolean previousButtonLast;
    private static boolean nextButtonLast;

    public static void updateButtons() {
        if (previousButton != previousButtonLast) {
            previousButtonLast = previousButton;
        }
        if (nextButton != nextButtonLast) {
            nextButtonLast = nextButton;
        }
        if (selectButton != selectButtonLast) {
            selectButtonLast = selectButton;
        }
        selectButton = IO.readShort(0x80) != 0;
        previousButton = IO.readShort(0x90) != 0;
        nextButton = IO.readShort(0x100) != 0;

    }

    public static boolean previousButtonPressed() {
        return IO.readShort(0x90) != 0;
    }

    public static boolean nextButtonPressed() {
        return IO.readShort(0x100) != 0;
    }

    public static boolean selectButtonPressed() {
        return IO.readShort(0x80) != 0;
    }

    public static boolean anyButtonPressed() {
        return nextButtonPressed() || previousButtonPressed() || selectButtonPressed();
    }

    public static boolean previousButtonChanged() {
        return previousButton != previousButtonLast;
    }

    public static boolean nextButtonChanged() {
        return nextButton != nextButtonLast;
    }

    public static boolean selectButtonChanged() {
        return selectButton != selectButtonLast;
    }

    public static boolean anyButtonChanged() {
        return nextButtonChanged() || previousButtonChanged() || selectButtonChanged();
    }

    public static String states() {
        return "Button{" +
                "selectButton=" + selectButton +
                ", previousButton=" + previousButton +
                ", nextButton=" + nextButton +
                ", selectButtonLast=" + selectButtonLast +
                ", previousButtonLast=" + previousButtonLast +
                ", nextButtonLast=" + nextButtonLast +
                '}';
    }

}
