public class Button {

    public static Boolean previousButtonPressed() {
        return IO.readShort(0x90) != 0;
    }

    public static Boolean nextButtonPressed() {
        return IO.readShort(0x100) != 0;
    }

    public static Boolean selectButtonPressed() {
        return IO.readShort(0x80) != 0;
    }
}
