import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {
        // Original data
//        double temp = Measurement.temperature((short) 20);
//        System.out.println(temp);

        // Reader to wait for user input
        Scanner reader = new Scanner(System.in);

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
        for (int i = 0; i < testBarometer.length - 1; i++) {
            double barometer = ValueConverter.barometer((short) testBarometer[i]);
            System.out.println(barometer + ", index:" + testBarometer[i]);
        }
        reader.next();
        // Temperature test
        for (int i = 0; i < testTemperature.length - 1; i++) {
            double temperature = ValueConverter.temperature((short) testTemperature[i]);
            System.out.println(temperature + ", index:" + testTemperature[i]);
        }
        reader.next();
        // Windspeed test
        for (int i = 0; i < testWindspeed.length - 1; i++) {
            double windSpeed = ValueConverter.windspeed((short) testWindspeed[i]);
            System.out.println(windSpeed + ", index:" + testWindspeed[i]);
        }
        reader.next();
        // Rainrate test
        for (int i = 0; i < testRainRate.length - 1; i++) {
            double rainRate = ValueConverter.rainrate((short) testRainRate[i]);
            System.out.println(rainRate + ", index:" + testRainRate[i]);
        }
        reader.next();
        // UvIndex test
        for (int i = 0; i < testUvIndex.length - 1; i++) {
            double UvIndex = ValueConverter.uvindex((short) testUvIndex[i]);
            System.out.println(UvIndex + ", index:" + testUvIndex[i]);
        }
        reader.next();
        // BetteryLevel test
        for (int i = 0; i < testBatteryLevel.length - 1; i++) {
            double batteryLevel = ValueConverter.batterylevel((short) testBatteryLevel[i]);
            System.out.println(batteryLevel + ", index:" + testBatteryLevel[i]);
        }
        reader.next();
        // Humidity test
        for (int i = 0; i < testHumidity.length - 1; i++) {
            double humidity = ValueConverter.humidity((short) testHumidity[i]);
            System.out.println(humidity + ", index:" + testHumidity[i]);
        }
        reader.next();
    }
}
