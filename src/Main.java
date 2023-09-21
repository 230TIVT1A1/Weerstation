

public class Main {
    public static void main(String[] args) {
        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawMeasurement);
        System.out.println(measurement.getOutsideTemp());
        System.out.println(measurement.getOutsideHum());
        System.out.println(measurement.getInsideTemp());
        System.out.println(measurement.getInsideHum());

        System.out.println(measurement.toString());
        boolean test = measurement.isValid();
        System.out.println(measurement.getDewpoint());
    }
}