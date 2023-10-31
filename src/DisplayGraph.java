import java.util.ArrayList;

public class DisplayGraph {
    public static void displayOutsideTempGraph(Period period) {
        ArrayList<Double> temperaturesOutside = new ArrayList<>();
        for (Measurement measurement : period.getMeasurements()) {
            temperaturesOutside.add(measurement.getOutsideTemp());
        }
        GUI.segmentNumber(period.getAverageOutsideTemp(), 0, "##.#");
        GUI.segmentNumber(period.getLowestOutsideTemp(), 1, "##.#");
        GUI.segmentNumber(period.getHighestOutsideTemp(), 2, "##.#");
        GUI.matrixGraph(temperaturesOutside,period.getLowestOutsideTemp(),period.getHighestOutsideTemp());
    }
    public static void displayInsideTempGraph(Period period) {
        ArrayList<Double> temperaturesInside = new ArrayList<>();
        for (Measurement measurement : period.getMeasurements()) {
            temperaturesInside.add(measurement.getInsideTemp());
        }
        GUI.segmentNumber(period.getAverageInsideTemp(), 0, "##.#");
        GUI.segmentNumber(period.getLowestInsideTemp(), 1, "##.#");
        GUI.segmentNumber(period.getHighestInsideTemp(), 2, "##.#");
        GUI.matrixGraph(temperaturesInside,period.getLowestInsideTemp(),period.getHighestInsideTemp());
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
    public static void displayDewpointGraph(Period period) {
        ArrayList<Double> dewpoint = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = measurement.getDewpoint();
            System.out.println(v);
            dewpoint.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(min, 1, "##.#");
        GUI.segmentNumber(max, 2, "##.#");
        GUI.matrixGraph(dewpoint, min, max);
    }
    public static void displayHeatindexGraph(Period period) {
        ArrayList<Double> heatindex = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = measurement.getHeatIndex();
            heatindex.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(min, 1, "##.#");
        GUI.segmentNumber(max, 2, "##.#");
        GUI.matrixGraph(heatindex, min, max);
    }
    public static void displaySolarradiationGraph(Period period) {
        ArrayList<Double> solarradiation = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = measurement.getSolarRad();
            solarradiation.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(min, 1, "##.#");
        GUI.segmentNumber(max, 2, "##.#");
        GUI.matrixGraph(solarradiation, min, max);
    }
    public static void displaySunriseGraph(Period period) {
        ArrayList<Double> sunrise = new ArrayList<>();
        double min = 2400;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = Double.parseDouble(measurement.getSunrise().replace(":",""));
            sunrise.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(((int) min)/100, 1, "");
        GUI.segmentNumber(((int) max)/100, 2, "");
        GUI.matrixGraph(sunrise, min, max);
    }

    public static void displaySunsetGraph(Period period) {
        ArrayList<Double> sunset = new ArrayList<>();
        double min = 2400;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = Double.parseDouble(measurement.getSunset().replace(":",""));
            sunset.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(((int) min)/100, 1, "");
        GUI.segmentNumber(((int) max)/100, 2, "");
        GUI.matrixGraph(sunset, min, max);
    }
    public static void displayUVIndexGraph(Period period) {
        ArrayList<Double> UVIndex = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = measurement.getUVLevel();
            UVIndex.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(min, 1, "");
        GUI.segmentNumber(max, 2, "");
        GUI.matrixGraph(UVIndex, min, max);
    }
    public static void displayWindchillGraph(Period period) {
        ArrayList<Double> windchill = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double max = 0;
        for (Measurement measurement : period.getMeasurements()) {
            double v = measurement.getWindChill();
            windchill.add(v);
            if (v>max)
                max = v;
            if (v<min)
                min = v;
        }
        GUI.segmentNumber(min, 1, "##.#");
        GUI.segmentNumber(max, 2, "##.#");
        GUI.matrixGraph(windchill, min, max);
    }
}