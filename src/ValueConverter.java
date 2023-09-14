import java.math.BigDecimal;

public class ValueConverter {

    public static void main(String[] Args) {
        System.out.println("Luchtdruk: " + airPressure((short) 30127));
        System.out.println("Temperatuur: " + temperature((short) 795));
        System.out.println("Luchtvochtigheid: " + humidity((short) 65));
        System.out.println("Windsnelheid: " + windSpeed((short) 34));
        System.out.println("Windrichting: " + windDirection((short) 72));
        System.out.println("regensnelheid " + rainRate((short) 300));
        System.out.println("batterylevel " + batteryLevel((short) 193));
        System.out.println("Sunrise: "  + sunrise((short) 2202));
        System.out.println("sunset: "  + sunrise((short) 2202));
    }

    public static double airPressure(short rawValue) {
        double press = 0;
        press = (rawValue / 1000) * 33.863889532610884;
        Double result = new BigDecimal(press).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static double temperature(short rawValue) {
        double calc = 0;
        calc = Math.round(((rawValue / 10) -32 ) * 0.55555555555);
        return calc;
    }

    public static int humidity(short rawValue) {
        int humidity = rawValue;
        return humidity;
    }

    public static double windSpeed(short rawValue) {
        double speed = rawValue * 1.609344;
        Double result = new BigDecimal(speed).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static int windDirection(short rawValue) {
        int result = rawValue ;
        return result;
    }

    public static double rainRate(short rawValue) {
        double rate = (rawValue / 100) * 25.40;
        Double result = new BigDecimal(rate).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;

    }

    public static double uvIndex(short rawValue) {
        double uv = rawValue / 10;
        return uv;

    }

    public static double batteryLevel(short rawValue) {
        double level = 1.0*((rawValue * 300) / 512) / 100;
        return level;
    }

    public static String sunrise(short rawValue) {
        int inputTime = rawValue;

        int hours = inputTime / 100;
        int minutes = inputTime % 100;

        String formattedTime = String.format(" %d:%02d", hours, minutes);
        return formattedTime;
    }

    public static String sunset(short rawValue) {
        int inputTime = rawValue;

        int hours = inputTime / 100;
        int minutes = inputTime % 100;

        String formattedTime = String.format(" %d:%02d", hours, minutes);
        return formattedTime;
    }
}
