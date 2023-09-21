

public class Main {
    public static void main(String[] args) {
        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawMeasurement);
        System.out.println(rawMeasurement.getInsideTemp());
        System.out.println(measurement.getInsideTemp());


        System.out.println(measurement.toString());
        boolean test = measurement.isValid();
    }
}