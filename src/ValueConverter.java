public class ValueConverter {
    public static double airPressure(short rawValue) {
        return (checkDoubleOverflow(rawValue) / 1000.0) * 33.863889532610884;
    }

    public static double temperature(short rawValue) {
        return ((checkDoubleOverflow(rawValue) / 10.0) - 32.0) * 5.0/9.0;
    }

    public static int humidity(short rawValue) {
        if (rawValue == Short.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (rawValue == Short.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return rawValue;
    }

    public static double windSpeed(short rawValue) {
        return checkDoubleOverflow(rawValue) * 1.609344;
    }

    public static int windDirection(short rawValue) {
        if (rawValue == Short.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (rawValue == Short.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return rawValue;
    }

    public static double rainRate(short rawValue) {
        return (checkDoubleOverflow(rawValue) / 100.0) * 25.4;
    }

    public static double uvIndex(short rawValue) {
        return checkDoubleOverflow(rawValue) / 10.0;
    }

    public static double batteryLevel(short rawValue) {
        return ((checkDoubleOverflow(rawValue) * 300) / 512.0) / 100;
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

    public static double checkDoubleOverflow(short rawValue) {
        if (rawValue == Short.MIN_VALUE) {
            return Double.MIN_VALUE;
        } else if (rawValue == Short.MAX_VALUE) {
            return Double.MAX_VALUE;
        }
        return rawValue;
    }
}

