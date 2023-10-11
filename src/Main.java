import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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

        /**
         Modus
         */
        System.out.println("Mode Binnentemperatuur: " + period.getInsideTempMode(measurements));
        System.out.println("Mode Buitentemperatuur: " + period.getOutsideTempMode(measurements));
        System.out.println("Mode Barometer: " + period.getBarometerMode(measurements));
        System.out.println("Mode Luchtvochtigheid Buiten: " + period.getOutsideHumidityMode(measurements));

        System.out.println("---------------------------------------------");

        /**
         Standaardafwijking
         */
        System.out.println("Standaardafwijking Binnentemperatuur: " + period.getInsideTempSD(measurements));
        System.out.println("Standaardafwijking Buitentemperatuur: " + period.getOutsideTempSD(measurements));
        System.out.println("Standaardafwijking Barometer: " + period.getBarometerSD(measurements));
        System.out.println("Standaardafwijking Luchtvochtigheid Buiten: " + period.getOutsideHumiditySD(measurements));

        /**
         Individual Assignment (Daan)
         Date of biggest difference between the WindChill and OutsideTemp
         */
        // Search back until 90 days ago
        int daysBack = 90;
        // Calculate period
        LocalDate now = LocalDate.now();
        LocalDate before = LocalDate.now().minusDays(daysBack);
        System.out.println("Begin of period: " + now.minusDays(daysBack));
        System.out.println("End of period: " + now);

        Period p = new Period();
        System.out.println("Biggest difference between the WindChill and OutsideTemp: " + p.getDiffWindChillAndOutsideTemp(before, now));
        System.out.println("Date when this happend: " + p.getDateBiggestDiff(before, now));
    }
}