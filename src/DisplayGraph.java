import java.util.ArrayList;

public class DisplayGraph {
    public static void displayOutsideTempGraph(Period period) {
        ArrayList<Double> tempuraturesOutside = new ArrayList<>();
        for (Measurement measurement : period.getMeasurements()) {
            tempuraturesOutside.add(measurement.getOutsideTemp());
        }
        GUI.segmentNumber(period.getAverageOutsideTemp(), 0, "##.#");
        GUI.segmentNumber(period.getLowestOutsideTemp(), 1, "##.#");
        GUI.segmentNumber(period.getHighestOutsideTemp(), 2, "##.#");
        GUI.matrixGraph(tempuraturesOutside,period.getLowestOutsideTemp(),period.getHighestOutsideTemp());
    }
    public static void displayInsideTempGraph(Period period) {
        ArrayList<Double> tempuraturesInside = new ArrayList<>();
        for (Measurement measurement : period.getMeasurements()) {
            tempuraturesInside.add(measurement.getInsideTemp());
        }
        GUI.segmentNumber(period.getAverageInsideTemp(), 0, "##.#");
        GUI.segmentNumber(period.getLowestInsideTemp(), 1, "##.#");
        GUI.segmentNumber(period.getHighestInsideTemp(), 2, "##.#");
        GUI.matrixGraph(tempuraturesInside,period.getLowestInsideTemp(),period.getHighestInsideTemp());
    }
    public static void displayBarometerGraph(Period period) {
        ArrayList<Double> barometer = new ArrayList<>();
        for (Measurement measurement : period.getMeasurements()) {
            barometer.add(measurement.getBarometer());
        }
        GUI.segmentNumber(period.getAverageBarometer(), 0, "##.#");
        GUI.segmentNumber(Math.round(period.getLowestBarometer())/10, 1, "");
        GUI.segmentNumber(Math.round(period.getHighestBarometer())/10, 2, "");
        GUI.matrixGraph(barometer,period.getLowestBarometer(),period.getHighestBarometer());
    }
    public static void displayOutsideHumidityGraph(Period period) {
        ArrayList<Double> humidity = new ArrayList<>();
        for (Measurement measurement : period.getMeasurements()) {
            humidity.add((double) measurement.getOutsideHum());
        }
        GUI.segmentNumber(Math.round(period.getAverageOutsideHumidity()), 0, "");
        GUI.segmentNumber(period.getLowestOutsideHumidity(), 1, "");
        GUI.segmentNumber(period.getHighestOutsideHumidity(), 2, "");
        GUI.matrixGraph(humidity,period.getLowestOutsideHumidity(),period.getHighestOutsideHumidity());
    }
}