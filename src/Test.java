import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {
        // Original data
//        double temp = Measurement.temperature((short) 20);
//        System.out.println(temp);

        // Reader to wait for user input
        Scanner reader = new Scanner(System.in);
        System.out.println("initializing tester");
        // Test array's for calculated methods
        int[] testBarometer = {0, 30000, -30000, 50000, -50000};
        int[] testTemperature = {0, 700, 850, 1000, -700, -1000, 50000, -50000};
        int[] testWindspeed = {0, 10, -10, 20, -20, 80, -80, 300, -300};
        int[] testRainRate = {0, 10, -10, 80, -80, 50000, -50000};
        int[] testUvIndex = {0, 10, -10, 20, -20, 80, -80, 300, -300};
        int[] testBatteryLevel = {0, 30, -30, 500, -500, 1000, -1000, 50000, -50000};
        int[] testHumidity = {0, 50, -50, 100, -100, 1000, -1000};


        // For-loop testArray's
        // Barometer test
        System.out.println("Barometer test:");
        for (int i = 0; i < testBarometer.length - 1; i++) {
            double barometer = ValueConverter.airPressure((short) testBarometer[i]);
            System.out.println("Output: "+barometer + ", Input:" + testBarometer[i]);
        }
        reader.next();
        // Temperature test
        System.out.println("Temperature test:");
        for (int i = 0; i < testTemperature.length - 1; i++) {
            double temperature = ValueConverter.temperature((short) testTemperature[i]);
            System.out.println("Output: "+temperature + ", Input:" + testTemperature[i]);
        }
        reader.next();
        // Windspeed test
        System.out.println("WindSpeed test:");
        for (int i = 0; i < testWindspeed.length - 1; i++) {
            double windSpeed = ValueConverter.windSpeed((short) testWindspeed[i]);
            System.out.println("Output: "+windSpeed + ", Input:" + testWindspeed[i]);
        }
        reader.next();
        // Rainrate test
        System.out.println("RainRate test:");
        for (int i = 0; i < testRainRate.length - 1; i++) {
            double rainRate = ValueConverter.rainRate((short) testRainRate[i]);
            System.out.println("Output: "+rainRate + ", Input:" + testRainRate[i]);
        }
        reader.next();
        // UvIndex test
        System.out.println("UVIndex test:");
        for (int i = 0; i < testUvIndex.length - 1; i++) {
            double UvIndex = ValueConverter.uvIndex(
                    (short) testUvIndex[i]);
            System.out.println("Output: "+UvIndex + ", Input:" + testUvIndex[i]);
        }
        reader.next();
        // BetteryLevel test
        System.out.println("BatteryLevel test:");
        for (int i = 0; i < testBatteryLevel.length - 1; i++) {
            double batteryLevel = ValueConverter.batteryLevel((short) testBatteryLevel[i]);
            System.out.println("Output: "+batteryLevel + ", Input:" + testBatteryLevel[i]);
        }
        reader.next();
        // Humidity test
        System.out.println("Humidity test:");
        for (int i = 0; i < testHumidity.length - 1; i++) {
            int humidity = ValueConverter.humidity((short) testHumidity[i]);
            System.out.println("Output: "+humidity + ", Input:" + testHumidity[i]);
        }
        reader.next();
    }
}
