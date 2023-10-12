import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IO.init();
        GUI.clearSegment();
        ArrayList<RawMeasurement> rawMeasurement = DatabaseConnection.getMeasurementsLastHour();
        for (RawMeasurement raw:rawMeasurement) {
            Measurement measurement = new Measurement(raw);
            GUI.segmentNumber(measurement.getOutsideTemp(), 0, "00.00");
            GUI.segmentNumber(measurement.getOutsideHum(), 1, "00");
            GUI.segmentNumber(measurement.getInsideTemp(), 2, "0.0");
            IO.delay(100);
        }
    }
}