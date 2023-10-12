import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ArrayList<RawMeasurement> rawMeasurements = DatabaseConnection.getMeasurementsLastHour();
        ArrayList<Measurement> measurements = new ArrayList<>();
        Period period = new Period();
        for (RawMeasurement rawMeasurement : rawMeasurements) {
            Measurement measurement = new Measurement(rawMeasurement);
            measurements.add(measurement);
        }
        /**
        Mediaan
         */
        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian(measurements));
        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian(measurements));
        System.out.println("Mediaan Barometer: " + period.getBarometerMedian(measurements));
        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian(measurements));

        System.out.println("---------------------------------------------");
        /**
        Laagste
         */
        System.out.println("Laagste Binnentemperatuur: " + period.getLowestInsideTemp(measurements));
        System.out.println("Laagste Buitentemperatuur: " + period.getLowestOutsideTemp(measurements));
        System.out.println("Laagste Barometer: " + period.getLowestBarometer(measurements));
        System.out.println("Laagste Luchtvochtigheid Buiten: " + period.getLowestOutsideHumidity(measurements));

        System.out.println("---------------------------------------------");
        /**
         Hoogste
         */
        System.out.println("Hoogste Binnentemperatuur: " + period.getHighestInsideTemp(measurements));
        System.out.println("Hoogste Buitentemperatuur: " + period.getHighestOutsideTemp(measurements));
        System.out.println("Hoogste Barometer: " + period.getHighestBarometer(measurements));
        System.out.println("Hoogste Luchtvochtigheid Buiten: " + period.getHighestOutsideHumidity(measurements));

        System.out.println("---------------------------------------------");
        /**
         Gemiddelde
         */
        System.out.println("Gemiddelde Binnentemperatuur: " + period.getAverageInsideTemp(measurements));
        System.out.println("Gemiddelde Buitentemperatuur: " + period.getAverageOutsideTemp(measurements));
        System.out.println("Gemiddelde Barometer: " + period.getAverageBarometer(measurements));
        System.out.println("Gemiddelde Luchtvochtigheid Buiten: " + period.getAverageOutsideHumidity(measurements));

        System.out.println("---------------------------------------------");
        /**
         Mediaan
         */
        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian(measurements));
        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian(measurements));
        System.out.println("Mediaan Barometer: " + period.getBarometerMedian(measurements));
        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian(measurements));

        System.out.println("---------------------------------------------");
        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawMeasurement);
//        System.out.println(measurement.getOutsideTemp());
//        System.out.println(measurement.getOutsideHum());
//        System.out.println(measurement.getInsideTemp());
//        IO.init();
//        GUI.clearSegment();
//        GUI.segmentNumber(measurement.getOutsideTemp(),0,"00.00");
//        GUI.segmentNumber(measurement.getOutsideHum(),1,"00");
//        GUI.segmentNumber(measurement.getInsideTemp(),2,"0.0");
        Period period = new Period(LocalDate.of(2023,10,3));
        System.out.println(period.longestRainFall());

    }

}