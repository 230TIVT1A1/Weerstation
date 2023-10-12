

public class Main {
    public static void main(String[] args) {
//        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
//        Measurement measurement = new Measurement(rawMeasurement);
//        System.out.println(measurement.getOutsideTemp());
//        System.out.println(measurement.getOutsideHum());
//        System.out.println(measurement.getInsideTemp());
//        IO.init();
//        GUI.clearSegment();
//        GUI.segmentNumber(measurement.getOutsideTemp(),0,"00.00");
//        GUI.segmentNumber(measurement.getOutsideHum(),1,"00");
//        GUI.segmentNumber(measurement.getInsideTemp(),2,"0.0");
        Period period = new Period(7);
        period.longestRainFall();
        period.maxTemperatureDifference();
        /**
         Mediaan
         */
        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian());
        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian());
        System.out.println("Mediaan Barometer: " + period.getBarometerMedian());
        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian());

        System.out.println("---------------------------------------------");
        /**
         Laagste
         */
        System.out.println("Laagste Binnentemperatuur: " + period.getLowestInsideTemp());
        System.out.println("Laagste Buitentemperatuur: " + period.getLowestOutsideTemp());
        System.out.println("Laagste Barometer: " + period.getLowestBarometer());
        System.out.println("Laagste Luchtvochtigheid Buiten: " + period.getLowestOutsideHumidity());

        System.out.println("---------------------------------------------");
        /**
         Hoogste
         */
        System.out.println("Hoogste Binnentemperatuur: " + period.getHighestInsideTemp());
        System.out.println("Hoogste Buitentemperatuur: " + period.getHighestOutsideTemp());
        System.out.println("Hoogste Barometer: " + period.getHighestBarometer());
        System.out.println("Hoogste Luchtvochtigheid Buiten: " + period.getHighestOutsideHumidity());

        System.out.println("---------------------------------------------");
        /**
         Gemiddelde
         */
        System.out.println("Gemiddelde Binnentemperatuur: " + period.getAverageInsideTemp());
        System.out.println("Gemiddelde Buitentemperatuur: " + period.getAverageOutsideTemp());
        System.out.println("Gemiddelde Barometer: " + period.getAverageBarometer());
        System.out.println("Gemiddelde Luchtvochtigheid Buiten: " + period.getAverageOutsideHumidity());

        System.out.println("---------------------------------------------");
        /**
         Mediaan
         */
        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian());
        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian());
        System.out.println("Mediaan Barometer: " + period.getBarometerMedian());
        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian());

        System.out.println("---------------------------------------------");


    }

}