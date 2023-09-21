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

    public String getStationId() {
        return this.stationId;
    }

    public LocalDateTime getDateStamp() {
        return this.dateStamp;
    }

    public double getBarometer() {
        return ValueConverter.airPressure(this.barometer);
    }

    public double getInsideTemp() {
        return ValueConverter.temperature(this.insideTemp);
    }

    public double getOutsideTemp() {
        return ValueConverter.temperature(this.outsideTemp);
    }

    public int getInsideHum() {
        return ValueConverter.humidity(this.insideHum);
    }

    public double getOutsideHum() {
        return ValueConverter.humidity(this.outsideHum);
    }

    public double getWindSpeed() {
        return ValueConverter.windSpeed(this.windSpeed);
    }

    public double getAvgWindSpeed() {
        return ValueConverter.windSpeed(this.avgWindSpeed);
    }

    public int getWindDir() {
        return ValueConverter.windDirection(this.windDir);
    }

    public double getRainRate() {
        return ValueConverter.rainRate(this.rainRate);
    }

    public double getUVLevel() {
        return ValueConverter.uvIndex(this.UVLevel);
    }

    public short getSolarRad() {
        return this.solarRad;
    }

    public double getXmitBatt() {
        return ValueConverter.batteryLevel(this.xmitBatt);
    }

    public double getBattLevel() {
        return ValueConverter.batteryLevel(this.battLevel);
    }

    public String getSunrise() {
        return ValueConverter.sunrise(this.sunrise);
    }

    public String getSunset() {
        return ValueConverter.sunset(this.sunset);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "stationId='" + getStationId() + '\'' +
                ", dateStamp=" + getDateStamp() +
                ", barometer=" + getBarometer() +
                ", insideTemp=" + getInsideTemp() +
                ", insideHum=" + getInsideHum() +
                ", outsideTemp=" + getOutsideTemp() +
                ", outsideHum=" + getOutsideHum() +
                ", windSpeed=" + getWindSpeed() +
                ", avgWindSpeed=" + getAvgWindSpeed() +
                ", windDir=" + getWindDir() +
                ", rainRate=" + getRainRate() +
                ", UVLevel=" + getUVLevel() +
                ", solarRad=" + getSolarRad() +
                ", xmitBatt=" + getXmitBatt() +
                ", battLevel=" + getBattLevel() +
                ", sunrise=" + getSunrise() +
                ", sunset=" + getSunset() +
                '}';
    }
}


