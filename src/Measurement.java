import java.sql.Date;
import java.time.LocalDateTime;

public class Measurement {
    private String stationId;
    private LocalDateTime dateStamp;
    private short barometer;
    private short insideTemp;
    private short insideHum;
    private short outsideTemp;
    private short windSpeed;
    private short avgWindSpeed;
    private short windDir;
    private short outsideHum;
    private short rainRate;
    private short UVLevel;
    private short solarRad;
    private short xmitBatt;
    private short battLevel;
    private short sunrise;
    private short sunset;

    public Measurement(RawMeasurement rawMeasurement) {
        this.stationId = rawMeasurement.getStationId();
        this.dateStamp = rawMeasurement.getDateStamp();
        this.barometer = rawMeasurement.getBarometer();
        this.insideTemp = rawMeasurement.getInsideTemp();
        this.outsideTemp = rawMeasurement.getOutsideTemp();
        this.insideHum = rawMeasurement.getInsideHum();
        this.outsideHum  = rawMeasurement.getOutsideHum();
        this.windSpeed = rawMeasurement.getWindSpeed();
        this.avgWindSpeed = rawMeasurement.getAvgWindSpeed();
        this.windDir = rawMeasurement.getWindDir();
        this.rainRate = rawMeasurement.getRainRate();
        this.UVLevel = rawMeasurement.getUVLevel();
        this.solarRad = rawMeasurement.getSolarRad();
        this.xmitBatt = rawMeasurement.getXmitBatt();
        this.battLevel = rawMeasurement.getBattLevel();
        this.sunrise = rawMeasurement.getSunrise();
        this.sunset = rawMeasurement.getSunset();

    }
    public double getInsideTemp(){
        return ValueConverter.temperature(this.insideTemp);
    }


}


