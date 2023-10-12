

public class Main {
    public static void main(String[] args) {
        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawMeasurement);
        System.out.println(measurement.getOutsideTemp());
        System.out.println(measurement.getOutsideHum());
        System.out.println(measurement.getInsideTemp());
        IO.init();
        GUI.drawPicture("/Icons/thermostat.png",1,1);
        GUI.drawPicture("/Icons/thermostatSelected.png",16,1);
//        GUI.drawPicture("/Icons/Clearer.png",0,0);
        GUI.clearSegment();
        GUI.segmentNumber(measurement.getOutsideTemp(),0,"00.00");
        GUI.segmentNumber(measurement.getOutsideHum(),1,"00");
        GUI.segmentNumber(measurement.getInsideTemp(),2,"0.0");

    }
}