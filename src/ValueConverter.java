import java.math.BigDecimal;

public class ValueConverter {

    public static void main(String[] Args) {
        System.out.println("Luchtdruk: " + airPressure((short) 50000));
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
        if (rawValue > 0  && rawValue < 32767) {
            double press = (rawValue / 1000.0) * 33.863889532610884;
            return Math.round(press * 10.0) / 10.0;
        }
        return 0;
    }

    public static double temperature(short rawValue) {
        if (rawValue < -4596 || rawValue > 10000) {
            return 0;
        }
        double calc = Math.round(((rawValue / 10.0) - 32) * 5.0/9.0 * 10.0) / 10.0;
        return calc;
    }

    public static int humidity(short rawValue) {
        if (rawValue >= 0 & rawValue <= 100) {
            int humidity = rawValue;
            return humidity;
        }
        return 0;
    }

    public static double windSpeed(short rawValue) {
        double speed = rawValue * 1.609344;
        if (rawValue < 0 || speed > 200.0) {
            return 0;
        }
        Double result = new BigDecimal(speed).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static int windDirection(short rawValue) {
        if (rawValue >= 0 && rawValue <= 360) {
            int result = rawValue ;
            return result;
        }
        return 0;
    }

    public static double rainRate(short rawValue) {
        if (rawValue >= 0 && rawValue <= 32767) {
            double rate = (rawValue / 100.0) * 25.4;
            Double result = new BigDecimal(rate).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return result;
        }
        return 0;
    }

    public static double uvIndex(short rawValue) {
        if (rawValue >= 0 && rawValue <= 10) {
            double uv = rawValue / 10.0;
            return uv;
        }
        return 0;
    }

    public static double batteryLevel(short rawValue) {
        if (rawValue > 0 || rawValue < 512) {
            double level = 1.0 * ((rawValue * 300) / 512) / 100;
            return level;
        }
        return 0;
    }

    public static String sunrise(short rawValue) {
        if (rawValue >= 0000 & rawValue <= 2359) {
            int inputTime = rawValue;
            int hours = inputTime / 100;
            int minutes = inputTime % 100;
            String formattedTime = String.format("%d:%02d", hours, minutes);
            return formattedTime;
        }
        return "Incorrect Time";
    }

    public static String sunset(short rawValue) {
        if (rawValue >= 0000 & rawValue <= 2359) {
            int inputTime = rawValue;
            int hours = inputTime / 100;
            int minutes = inputTime % 100;
            String formattedTime = String.format("%d:%02d", hours, minutes);
            return formattedTime;
        }
        return "Incorrect Time";
    }
}

