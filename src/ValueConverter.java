import java.math.BigDecimal;

public class ValueConverter {

    public static void main(String[] Args) {
        System.out.println("Luchtdruk: " + airPressure((short) 30500));
        System.out.println("Temperatuur: " + temperature((short) 775));
        System.out.println("Luchtvochtigheid: " + humidity((short) 65));
        System.out.println("Windsnelheid: " + windSpeed((short) 25));
        System.out.println("Windrichting: " + windDirection((short) 72));
        System.out.println("regensnelheid " + rainRate((short) 300));
        System.out.println("batterylevel " + batteryLevel((short) 193));
        System.out.println("Sunrise: "  + sunrise((short) 526));
        System.out.println("Sunset: "  + sunset((short) 2202));
    }

    public static double airPressure(short rawValue) {
        if (rawValue > 0) {
            double press = (rawValue / 1000.0) * 33.863889532610884;
            return Math.round(press * 10.0) / 10.0;
        }
        return 0;
    }

    public static double temperature(short rawValue) {
        if (rawValue < -4596 || rawValue > 10000) {
            throw new IllegalArgumentException("Input rawValue is out of valid range for temperature.");
        }
        double calc = Math.round(((rawValue / 10.0) - 32) * 5.0/9.0 * 10.0) / 10.0;
        return calc;
    }

    public static int humidity(short rawValue) {
        int humidity = rawValue;
        return humidity;
    }

    public static double windSpeed(short rawValue) {
        if (rawValue < 0) {
            throw new IllegalArgumentException("Wind speed cannot be negative.");
        }
        double speed = rawValue * 1.609344;
        if (speed > 200.0) {
            throw new IllegalArgumentException("Wind speed value is unrealistically high.");
        }
        Double result = new BigDecimal(speed).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static int windDirection(short rawValue) {
        int result = rawValue ;
        return result;
    }

    public static double rainRate(short rawValue) {
        double rate = (rawValue / 100.0) * 25.4;
        Double result = new BigDecimal(rate).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static double uvIndex(short rawValue) {
        if (rawValue < 0) {
            throw new IllegalArgumentException("UV index value cannot be negative.");
        }
        double uv = rawValue / 10.0;
        return uv;
    }

    public static double batteryLevel(short rawValue) {
        if (rawValue < 0 || rawValue > 512) {
            throw new IllegalArgumentException("Battery level value is out of valid range.");
        }
        double level = 1.0 * ((rawValue * 300) / 512) / 100;
        return level;
    }

    public static String sunrise(short rawValue) {
        int inputTime = rawValue;

        int hours = inputTime / 100;
        int minutes = inputTime % 100;

        String formattedTime = String.format("%d:%02d", hours, minutes);
        return formattedTime;
    }

    public static String sunset(short rawValue) {
        int inputTime = rawValue;

        int hours = inputTime / 100;
        int minutes = inputTime % 100;

        String formattedTime = String.format("%d:%02d", hours, minutes);
        return formattedTime;
    }
}
