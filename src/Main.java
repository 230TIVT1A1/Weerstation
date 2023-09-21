

public class Main {
    public static void main(String[] args) {
        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
        System.out.println(rawMeasurement);

        Measurement measurement = new Measurement(rawMeasurement);

    }
}