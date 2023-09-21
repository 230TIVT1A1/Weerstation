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

    public double getWindChill() {
        return 13.12 + 0.625*this.getOutsideTemp() - 11.37*Math.pow(this.getWindSpeed(),0.16) + 0.3965*this.getOutsideTemp()*Math.pow(this.getWindSpeed(),0.16);
    }

    public double getHeatIndex() {
        return (-8.78469475556
                + 1.61139411*this.getOutsideTemp()
                + 2.33854883889*this.getOutsideHum()
                + -0.14611605*this.getOutsideTemp()*this.getOutsideHum()
                + -0.012308094*Math.pow(this.getOutsideTemp(),2)
                + -0.0164248277778*Math.pow(this.getOutsideHum(), 2)
                + 0.002211732*Math.pow(this.getOutsideTemp(),2)*this.getOutsideHum()
                + 0.00072546*Math.pow(this.getOutsideHum(),2)*this.getOutsideTemp()
                + -0.000003582*Math.pow(this.getOutsideHum(),2)*Math.pow(this.getOutsideTemp(),2)
        );
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
                ", windChill=" + getWindChill() +
                ", heatIndex=" + getHeatIndex() +
                ", dewPoint=" + getDewpoint() +
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
    public double getDewpoint() {
        int humidity = (getInsideHum());
        double temp = (getInsideTemp());

        return temp - ((100.0 - humidity) / 5);
    }

}


