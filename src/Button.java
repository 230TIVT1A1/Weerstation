public class Button {

    public Boolean previousButtonPressed() {
        return IO.readShort(0x90) != 0;
    }

    public Boolean nextButtonPressed() {
        return IO.readShort(0x100) != 0;
    }

    public Boolean selectButtonPressed() {
        return IO.readShort(0x80) != 0;
    }
}
