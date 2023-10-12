import java.time.LocalDate;
import java.util.ArrayList;
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
        /**
         Mediaan
         */
        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian(period.getMeasurements()));
        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian(period.getMeasurements()));
        System.out.println("Mediaan Barometer: " + period.getBarometerMedian(period.getMeasurements()));
        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian(period.getMeasurements()));

        System.out.println("---------------------------------------------");
        /**
         Laagste
         */
        System.out.println("Laagste Binnentemperatuur: " + period.getLowestInsideTemp(period.getMeasurements()));
        System.out.println("Laagste Buitentemperatuur: " + period.getLowestOutsideTemp(period.getMeasurements()));
        System.out.println("Laagste Barometer: " + period.getLowestBarometer(period.getMeasurements()));
        System.out.println("Laagste Luchtvochtigheid Buiten: " + period.getLowestOutsideHumidity(period.getMeasurements()));

        System.out.println("---------------------------------------------");
        /**
         Hoogste
         */
        System.out.println("Hoogste Binnentemperatuur: " + period.getHighestInsideTemp(period.getMeasurements()));
        System.out.println("Hoogste Buitentemperatuur: " + period.getHighestOutsideTemp(period.getMeasurements()));
        System.out.println("Hoogste Barometer: " + period.getHighestBarometer(period.getMeasurements()));
        System.out.println("Hoogste Luchtvochtigheid Buiten: " + period.getHighestOutsideHumidity(period.getMeasurements()));

        System.out.println("---------------------------------------------");
        /**
         Gemiddelde
         */
        System.out.println("Gemiddelde Binnentemperatuur: " + period.getAverageInsideTemp(period.getMeasurements()));
        System.out.println("Gemiddelde Buitentemperatuur: " + period.getAverageOutsideTemp(period.getMeasurements()));
        System.out.println("Gemiddelde Barometer: " + period.getAverageBarometer(period.getMeasurements()));
        System.out.println("Gemiddelde Luchtvochtigheid Buiten: " + period.getAverageOutsideHumidity(period.getMeasurements()));

        System.out.println("---------------------------------------------");
        /**
         Mediaan
         */
        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian(period.getMeasurements()));
        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian(period.getMeasurements()));
        System.out.println("Mediaan Barometer: " + period.getBarometerMedian(period.getMeasurements()));
        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian(period.getMeasurements()));

        System.out.println("---------------------------------------------");

        /**
         Modus
         */
        System.out.println("Mode Binnentemperatuur: " + period.getInsideTempMode(period.getMeasurements()));
        System.out.println("Mode Buitentemperatuur: " + period.getOutsideTempMode(period.getMeasurements()));
        System.out.println("Mode Barometer: " + period.getBarometerMode(period.getMeasurements()));
        System.out.println("Mode Luchtvochtigheid Buiten: " + period.getOutsideHumidityMode(period.getMeasurements()));

        System.out.println("---------------------------------------------");

        /**
         Standaardafwijking
         */
        System.out.println("Standaardafwijking Binnentemperatuur: " + period.getInsideTempSD(period.getMeasurements()));
        System.out.println("Standaardafwijking Buitentemperatuur: " + period.getOutsideTempSD(period.getMeasurements()));
        System.out.println("Standaardafwijking Barometer: " + period.getBarometerSD(period.getMeasurements()));
        System.out.println("Standaardafwijking Luchtvochtigheid Buiten: " + period.getOutsideHumiditySD(period.getMeasurements()));

        System.out.println("---------------------------------------------");
        
        /**
         Individual Assignment (Daan)
         Date of biggest difference between the WindChill and OutsideTemp
         */
        System.out.println("Biggest difference between the WindChill and OutsideTemp: " + period.getDiffWindChillAndOutsideTemp());
        System.out.println("Date when this happend: " + period.getDateBiggestDiff());
    }

}