import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Original data
//        double temp = Measurement.temperature((short) 20);
//        System.out.println(temp);

        // Reader to wait for user input
        Scanner reader = new Scanner(System.in);
        System.out.println("initializing tester");
        // Test array's for calculated methods
        // 2,3,4 and 5 are real data
        int[] testBarometer = {0, 30084, 30279, 30138, 29902, 30000, -30000, 50000, -50000};
        // 2 and 3 are real data from insideTemp,4 and 5 are real data from outsideTemp
        int[] testTemperature = {0, 763, 858, 798, 769, 700, 850, 1000, -700, -1000, 50000, -50000};
        // 2,3,4 and 5 are real data
        int[] testWindspeed = {0, 14, 5, 4, 13, 10, -10, 20, -20, 80, -80, 300, -300};
        // 2,3,4 and 5 are real data
        int[] testWindDirection = {0, 293, 37, 61, 273, 100, -100, 360, -360, 1000, -1000};
        // 2 is real data
        int[] testRainRate = {0, 0, 0, 0, 0, 10, -10, 80, -80, 50000, -50000};
        // 2,3,4 and 5 are real data
        int[] testUvIndex = {0, 66, 5, 6, 25, 10, -10, 20, -20, 80, -80, 300, -300};
        // 2,3,4 and 5 are real data
        int[] testBatteryLevel = {0, 193, 195, 201, 210, 30, -30, 500, -500, 1000, -1000, 50000, -50000};
        // 2 and 3 are real data from insideHum,4 and 5 are real data from outsideHum
        int[] testHumidity = {0, 32, 25, 57, 72, 50, -50, 100, -100, 1000, -1000};
        // 2,3,4 and 5 are real data
        int[] testSunrise = {0, 526, 527, 531, 532, 500, -500, 1000, -1000, 10000, -10000};
        // 2,3,4 and 5 are real data
        int[] testSunset = {0, 2202, 2203, 2202, 2201, 500, -500, 1000, -1000, 10000, -10000};

        // For-loop testArray's
        // Barometer test
        System.out.println("Barometer test:");
        for (int i = 0; i < testBarometer.length; i++) {
            double barometer = ValueConverter.airPressure((short) testBarometer[i]);
            System.out.println("Output: " + barometer + ", Input:" + testBarometer[i]);
        }
        System.out.println("Expected result for 2 is: 1018,761253");
        System.out.println("Expected result for 3 is: 1025,364711");
        System.out.println("Expected result for 4 is: 1020,589903");
        System.out.println("Expected result for 5 is: 1012,598025");
        reader.next();
        // Temperature test
        System.out.println("Temperature test:");
        for (int i = 0; i < testTemperature.length; i++) {
            double temperature = ValueConverter.temperature((short) testTemperature[i]);
            System.out.println("Output: " + temperature + ", Input:" + testTemperature[i]);
        }
        System.out.println("Expected result for 2 is: 24,61111111");
        System.out.println("Expected result for 3 is: 29,88888889");
        System.out.println("Expected result for 4 is: 26,55555556");
        System.out.println("Expected result for 5 is: 24,94444444");
        reader.next();
        // Windspeed test
        System.out.println("WindSpeed test:");
        for (int i = 0; i < testWindspeed.length; i++) {
            double windSpeed = ValueConverter.windSpeed((short) testWindspeed[i]);
            System.out.println("Output: " + windSpeed + ", Input:" + testWindspeed[i]);
        }
        System.out.println("Expected result for 2 is: 22,530816");
        System.out.println("Expected result for 3 is: 8,04672");
        System.out.println("Expected result for 4 is: 17,702784");
        System.out.println("Expected result for 5 is: 28,968192");
        reader.next();
        // Rainrate test
        System.out.println("RainRate test:");
        for (int i = 0; i < testRainRate.length; i++) {
            double rainRate = ValueConverter.rainRate((short) testRainRate[i]);
            System.out.println("Output: " + rainRate + ", Input:" + testRainRate[i]);
        }
        System.out.println("Expected result for 2 is: 0");
        System.out.println("Expected result for 3 is: 0");
        System.out.println("Expected result for 4 is: 0");
        System.out.println("Expected result for 5 is: 0");
        reader.next();
        // UvIndex test
        System.out.println("UVIndex test:");
        for (int i = 0; i < testUvIndex.length; i++) {
            double UvIndex = ValueConverter.uvIndex(
                    (short) testUvIndex[i]);
            System.out.println("Output: " + UvIndex + ", Input:" + testUvIndex[i]);
        }
        System.out.println("Expected result for 2 is: 6,6");
        System.out.println("Expected result for 3 is: 0,5");
        System.out.println("Expected result for 4 is: 0,6");
        System.out.println("Expected result for 5 is: 2,5");
        reader.next();
        // BatteryLevel test
        System.out.println("BatteryLevel test:");
        for (int i = 0; i < testBatteryLevel.length; i++) {
            double batteryLevel = ValueConverter.batteryLevel((short) testBatteryLevel[i]);
            System.out.println("Output: " + batteryLevel + ", Input:" + testBatteryLevel[i]);
        }
        System.out.println("Expected result for 2 is: 1,130859375");
        System.out.println("Expected result for 3 is: 1,142578125");
        System.out.println("Expected result for 4 is: 1,177734375");
        System.out.println("Expected result for 5 is: 1,23046875");
        reader.next();
        // Humidity test
        System.out.println("Humidity test:");
        for (int i = 0; i < testHumidity.length; i++) {
            int humidity = ValueConverter.humidity((short) testHumidity[i]);
            System.out.println("Output: " + humidity + ", Input:" + testHumidity[i]);
        }
        System.out.println("Expected result for 2 is: 32%");
        System.out.println("Expected result for 3 is: 25%");
        System.out.println("Expected result for 4 is: 57%");
        System.out.println("Expected result for 5 is: 72%");
        reader.next();
        // Sunrise test
        System.out.println("Sunrise test:");
        for (int i = 0; i < testSunrise.length; i++) {
            String sunrise = ValueConverter.sunrise((short) testSunrise[i]);
            System.out.println("Output: " + sunrise + ", Input:" + testSunrise[i]);
        }
        System.out.println("Expected result for 2 is: 526");
        System.out.println("Expected result for 3 is: 527");
        System.out.println("Expected result for 4 is: 531");
        System.out.println("Expected result for 5 is: 532");
        reader.next();
        // Sunset test
        System.out.println("Sunset test:");
        for (int i = 0; i < testSunset.length; i++) {
            String sunset = ValueConverter.sunset((short) testSunset[i]);
            System.out.println("Output: " + sunset + ", Input:" + testSunset[i]);
        }
        System.out.println("Expected result for 2 is: 2202");
        System.out.println("Expected result for 3 is: 2203");
        System.out.println("Expected result for 4 is: 2202");
        System.out.println("Expected result for 5 is: 2201");
        reader.next();
        // WindDirection test
        System.out.println("WindDirection test:");
        for (int i = 0; i < testWindDirection.length; i++) {
            int windDirection = ValueConverter.windDirection((short) testWindDirection[i]);
            System.out.println("Output: " + windDirection + ", Input:" + testWindDirection[i]);
        }
        System.out.println("Expected result for 2 is: 293");
        System.out.println("Expected result for 3 is: 37");
        System.out.println("Expected result for 4 is: 61");
        System.out.println("Expected result for 5 is: 273");
        reader.next();
    }
}
