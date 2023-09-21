import java.sql.Date;
import java.time.LocalDateTime;

public class Measurement {
    private RawMeasurement rawMeasurement;

    public Measurement(RawMeasurement rawMeasurement) {
        this.rawMeasurement = rawMeasurement;
    }

    public String getStationId() {
        return this.rawMeasurement.getStationId();
    }

    public LocalDateTime getDateStamp() {
        return this.rawMeasurement.getDateStamp();
    }

    public double getBarometer() {
        return ValueConverter.airPressure(this.rawMeasurement.getBarometer());
    }

    public double getInsideTemp() {
        return ValueConverter.temperature(this.rawMeasurement.getInsideTemp());
    }

    public double getOutsideTemp() {
        return ValueConverter.temperature(this.rawMeasurement.getOutsideTemp());
    }

    public int getInsideHum() {
        return ValueConverter.humidity(this.rawMeasurement.getInsideHum());
    }

    public int getOutsideHum() {
        return ValueConverter.humidity(this.rawMeasurement.getOutsideHum());
    }

    public double getWindSpeed() {
        return ValueConverter.windSpeed(this.rawMeasurement.getWindSpeed());
    }

    public double getAvgWindSpeed() {
        return ValueConverter.windSpeed(this.rawMeasurement.getAvgWindSpeed());
    }

    public int getWindDir() {
        return ValueConverter.windDirection(this.rawMeasurement.getWindDir());
    }

    public double getRainRate() {
        return ValueConverter.rainRate(this.rawMeasurement.getRainRate());
    }

    public double getUVLevel() {
        return ValueConverter.uvIndex(this.rawMeasurement.getUVLevel());
    }

    public double getSolarRad() {
        return this.rawMeasurement.getSolarRad();
    }

    public double getXmitBatt() {
        return ValueConverter.batteryLevel(this.rawMeasurement.getXmitBatt());
    }

    public double getBattLevel() {
        return ValueConverter.batteryLevel(this.rawMeasurement.getBattLevel());
    }

    public String getSunrise() {
        return ValueConverter.sunrise(this.rawMeasurement.getSunrise());
    }

    public String getSunset() {
        return ValueConverter.sunset(this.rawMeasurement.getSunset());
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
    public boolean isValid(){
        checkShortOverflow(this.rawMeasurement.getBarometer());
        return false;
    }
    public static boolean checkShortOverflow(short rawValue) {
        if (rawValue == Short.MIN_VALUE) {
            return false;
        } else if (rawValue == Short.MAX_VALUE) {
            return false;
        }
        return true;
    }
}


