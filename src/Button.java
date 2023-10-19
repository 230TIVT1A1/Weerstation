public class Button {
    public static void main(String[] Args) {
        IO.init();
    }

    public void listenForButtons() {
        while (true) {
            if ( IO.readShort(0x80) != 0 ) {
                // Select functie
            }
            if ( IO.readShort(0x90) != 0 ) {
                // Previous functie
            }
            if ( IO.readShort(0x100) != 0 ) {
                // Next functie
            }
        }
    }
}
