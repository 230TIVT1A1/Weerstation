import java.text.DecimalFormat;
import java.util.ArrayList;

public class GUI {
    public static final int HEIGHT = 32;
    public static final int WIDTH = 128;

    public static void clrDisplay() {
        IO.writeShort(0x40, 0xFE);
        IO.writeShort(0x40, 0x01);
    }

    public static void setPixel(int x, int y, boolean state) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            int opcode;
            if (state) {
                opcode = 1;
            } else {
                opcode = 0;
            }
            IO.writeShort(0x42, opcode << 12 | x << 5 | y);
        }
    }

    public static void matrixGraph(ArrayList<Double> input){//todo deze vervangen door methode van tiemen
        // only displays values between 0 and 32 correctly
        for (int x = 0; x < input.size(); x++) {
            IO.writeShort(0x42, 1 << 12 | x << 5 | 32 - ((int) Math.round(input.get(x))));
        }
    }

    public static void clearSegment() {
        int[] addresses = new int[]{0x10, 0x20, 0x30};
        int[] segSize = new int[]{5, 3, 3};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < segSize[i]; j++) {
                IO.writeShort(addresses[i] + j * 2, 0x100);
            }
        }
    }

    public static void segmentNumber(double inPrint, int group, String format) {
        int[] segSize = new int[]{5, 3, 3};
        int[] chars = new int[]{0b00111111, 0b00000110, 0b01011011, 0b1001111, 0b1100110, 0b1101101, 0b1111101, 0b0000111, 0b1111111, 0b1101111};
        int[] addresses = new int[]{0x18, 0x24, 0x34};
        DecimalFormat df = new DecimalFormat(format);
        String inputString = df.format(inPrint);
        char chr = ' ';
        if(inputString.contains(".")) {
            chr = '.';
        }else if(inputString.contains(",")) {
            chr = ',';
        }
        inputString = inputString.replace("-", "");
        int indexPoint = inputString.indexOf(chr);
        inputString = inputString.replace(""+chr, "");
        int addressShift = segSize[group] - inputString.length() - 1;
        for (int i = 0; i < inputString.length(); i++) {
            int chrInt = inputString.charAt(i) - '0';
            int hexOut = chars[chrInt];
            int point = 0;
            if (indexPoint == i + 1) {
                point = 0b010000000;
            }
            IO.writeShort(addresses[group] - (i + 1 + addressShift) * 2, 0x100 | hexOut | point);
        }
        if (inPrint < 0) {
            int minus = 0b001000000;
            IO.writeShort(addresses[group] - addressShift * 2, 0x100 | minus);
        } else {
            IO.writeShort(addresses[group] - addressShift * 2, 0x100);
        }
    }

    public static void showText(String text){
        // Spaces / refreshing the screen
        for (int p = 0; p <= text.length() / 21; p++){
            if ((p%3) == 0){
                continue;
            }
            if (text.length() > (21 * p)){
                text = text.substring(0, (21 * p)) + "\n" + text.substring((21 * p)).trim();
            }
        }
        // Placing text
        int charactersTyped = 0;
        int maxCharactersOnScreen = 63;
        for (int j = 0;j < text.length();j++) {
            int pos = text.indexOf(' ');
            String first = "";
            if (pos < 1) {
                first = text;
            } else {
                first = text.substring(0, pos);
            }
            for (int i = 0; i < first.length(); i++) {
                // Clear screen if it's full
                if (charactersTyped == maxCharactersOnScreen){
                    clrDisplay();
                    charactersTyped = 0;
                }
                char c = text.charAt(0);
                IO.writeShort(0x40, c);
                charactersTyped++;
                text = text.substring(1);
                // Slow typing animation
                IO.delay(50);
            }
        }
    }
}
