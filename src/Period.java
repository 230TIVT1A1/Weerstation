import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections;

/**
 * A class to contain a period of time
 *
 * @author Johan Talboom
 * @version 2.0
 */
public class Period {
    private LocalDate beginPeriod;
    private LocalDate endPeriod;

    /**
     * default constructor, sets the period to today
     */
    public Period() {
        beginPeriod = LocalDate.now();
        endPeriod = LocalDate.now();
    }

    public Period(LocalDate beginPeriod, LocalDate endPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = endPeriod;
    }

    public Period(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = LocalDate.now();
    }

    public Period(int days) {
        this.beginPeriod = LocalDate.now().minus(java.time.Period.ofDays(days));
        this.endPeriod = LocalDate.now();
    }

	public LocalDate getBeginPeriod() {
		return beginPeriod;
	}

	public LocalDate getEndPeriod() {
		return endPeriod;
	}

    /**
     * Simple setter for start of period
     */
    public void setStart(int year, int month, int day) {
        beginPeriod = LocalDate.of(year, month, day);
    }

    /**
     * simple setter for end of period
     */
    public void setEnd(int year, int month, int day) {
        endPeriod = LocalDate.of(year, month, day);
    }

    /**
     * alternative setter for start of period
     *
     * @param beginPeriod
     */
    public void setStart(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    /**
     * alternative setter for end of period
     *
     * @param endPeriod
     */
    public void setEnd(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    /**
     * calculates the number of days in the period
     */
    public long numberOfDays() {
        return ChronoUnit.DAYS.between(beginPeriod, endPeriod);
    }


    /**
     * gets all raw measurements of this period from the database
     *
     * @return a list of raw measurements
     */
    public ArrayList<RawMeasurement> getRawMeasurements() {
        return DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(beginPeriod, LocalTime.of(0, 1)), LocalDateTime.of(endPeriod, LocalTime.of(23, 59)));
    }

    /**
     * Builds an ArrayList of measurements. This method also filters out any 'bad' measurements
     *
     * @return a filtered list of measurements
     */
    public ArrayList<Measurement> getMeasurements() {
        ArrayList<Measurement> measurements = new ArrayList<>();
        ArrayList<RawMeasurement> rawMeasurements = getRawMeasurements();
        for (RawMeasurement rawMeasurement : rawMeasurements) {
            Measurement measurement = new Measurement(rawMeasurement);
            if (measurement.isValid()) {
                measurements.add(measurement);
            }
        }
        return measurements;
    }

	/**
	 *
	 * @param menu the data you want to calculate
	 * @param calculation the kind of caluclation to be done on the data of menu
	 * @return the outcome of the calculation in a double.
	 */
	public double calculatePeriod(String calculation, String menu) {
		ArrayList<Double> measurements = new ArrayList<>();
		switch(menu) {
			case "hum":
				for (Measurement measurement : getMeasurements()) {
					double hum = measurement.getOutsideHum();
					measurements.add(hum);
				}
				break;
			case "intemp":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getInsideTemp());
				}
				break;
			case "outtemp":
				for(Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getOutsideTemp());
				}
			case "wind":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getWindSpeed());
				}
				break;
			case "bar":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getBarometer());
				}
				break;
			case "dew":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getDewpoint());
				}
				break;
			case "heat":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getHeatIndex());
				}
				break;
			case "rain":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getRainRate());
				}
				break;
			case "solar":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getSolarRad());
				}
				break;
			case "uv":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getUVLevel());
				}
				break;
			case "chill":
				for (Measurement measurement : getMeasurements()) {
					measurements.add(measurement.getWindChill());
				}
				break;
		}

		double returnVar = 0;
		switch(calculation) {
			case "minimaal":
				double lowest = measurements.get(0);
				for (double measurement : measurements) {
					if (measurement < lowest) {
						lowest = measurement;
					}
				}
				returnVar = lowest;
				break;
			case "maximaal":
				double highest = measurements.get(0);
				for (double measurement : measurements) {
					if (measurement > highest) {
						highest = measurement;
					}
				}
				returnVar = highest;
				break;
			case "gemiddeld":
				double sum = 0;
				for (double measurement : measurements) {
					sum += measurement;
				}
				returnVar = sum / measurements.size();
				break;
			case "mediaan":
				Collections.sort(measurements);
				int middle = (measurements.size() + 1) / 2;

				returnVar = measurements.get(middle);
				break;
			case "modus":
				ArrayList<Double> speeds = new ArrayList<>();
				for (Measurement measurement : this.getMeasurements()) {
					speeds.add(measurement.getWindSpeed());
				}
				int maxFrequenty = 0;
				double mode = 0.0;
				for (int i = 0; i < measurements.size(); i++) {
					int count = 0;
					for (int j = 0; j < measurements.size(); j++) {
						if (measurements.get(i) == measurements.get(j)) {
							count++;
						}

						if (count > maxFrequenty) {
							maxFrequenty = count;
							mode = measurements.get(i);
						}
					}
				}
				returnVar = mode;
				break;
			case "standaardafwijking":
				double dividend = 0.0;
				double average = this.calculatePeriod("gemiddeld", menu);
				for (Double measurement : measurements) {
					dividend += (measurement - average) * (measurement - average);
				}
				returnVar = Math.sqrt(dividend/(measurements.size()-1));
				break;
		}

		return returnVar;
	}

	// individual assignment Melvin
	public Double maxTemperatureDifference() {

		if (getMeasurements().isEmpty()) {
			return null;
		}

		double maxTemp = getMeasurements().get(0).getOutsideTemp();
		double minTemp = getMeasurements().get(0).getOutsideTemp();

		for (Measurement measurement : getMeasurements()) {
			double outsideTemp = measurement.getOutsideTemp();

			if (outsideTemp > maxTemp) {
				maxTemp = outsideTemp;
			}

			if (outsideTemp < minTemp) {
				minTemp = outsideTemp;
			}
		}

        return maxTemp - minTemp;
	}

	// individual assignment Storm
	/**
	 * checks when the longest rain took place
	 *
	 * @return a list with time of the rainfall and the start and end date
	 */
	public ArrayList<String> longestRainFall() {
		ArrayList<Measurement> arrayMeasurement = getMeasurements();
		ArrayList<String> returnList = new ArrayList<>();
		LocalDateTime startDate = this.beginPeriod.atStartOfDay();
		LocalDateTime endDate = null;
		long longestRain = 0;
		for (Measurement mes : arrayMeasurement) {
			LocalDateTime mesDateStamp = mes.getDateStamp();
			if (mes.getRainRate() == 0.0) {
				startDate = mesDateStamp;
			} else {
				long rainTime = startDate.until(mesDateStamp, ChronoUnit.MINUTES);
				if (longestRain < rainTime) {
					longestRain = rainTime;
					endDate = mesDateStamp;
					returnList.clear();
					returnList.add(String.valueOf(longestRain));
					returnList.add(String.valueOf(startDate));
					returnList.add(String.valueOf(endDate));
				}
			}
		}
		return returnList;
	}

	// individual assignment Daan
	public double getDiffWindChillAndOutsideTemp(){
		double biggestDifference = 0;
		for (Measurement measurement : this.getMeasurements()){
			double outsideTemp = measurement.getOutsideTemp();
			// Overflow Check
			if (outsideTemp > 1000 || outsideTemp < -1000){
				continue;
			}
			double windChill = measurement.getWindChill();
			// Overflow Check
			if (windChill > 1000 || windChill < -1000){
				continue;
			}
			double biggestDiff = windChill - outsideTemp;
			double biggestDiff2 = outsideTemp - windChill;
			if (biggestDiff > 0 && biggestDiff2 <= 0 && biggestDiff > biggestDifference){
				biggestDifference = biggestDiff;
			} else if (biggestDiff2 > 0 && biggestDiff <= 0 && biggestDiff2 > biggestDifference){
				biggestDifference = biggestDiff2;
			}
		}
		return biggestDifference;
	}

	public LocalDate getDateBiggestDiff(){
		double biggestDiff = getDiffWindChillAndOutsideTemp();
		LocalDate theDate = null;
		for (Measurement measurement : this.getMeasurements()){
			LocalDate date = LocalDate.from(measurement.getDateStamp());
			if ((measurement.getOutsideTemp() - measurement.getWindChill()) > 0){
				if ((measurement.getOutsideTemp() - measurement.getWindChill()) == biggestDiff){
					theDate = date;
				}
			} else if ((measurement.getWindChill() - measurement.getOutsideTemp()) > 0){
				if ((measurement.getWindChill() - measurement.getOutsideTemp()) == biggestDiff){
					theDate = date;
				}
			}
		}
		return theDate;
	}

	// individual assignment Lucas
	public boolean Heatwave() {
		int degrees30 = 0;
		int degrees25 = 0;
		int counter = 0;
		for(Measurement measurement: this.getMeasurements()) {
			if(measurement.getOutsideTemp() < 25) {
				degrees25 = 0;
				degrees30 = 0;
				counter = 0;
			}
			if(measurement.getOutsideTemp() >= 25 && measurement.getOutsideTemp() < 30) { degrees25++; counter++; }
			if(measurement.getOutsideTemp() >= 30) { degrees30++; counter++; }


			if (counter == 5 && degrees30 < 3) {
				counter--;
				if (degrees25 >= 3) degrees25--;
			}

			if(degrees30 >= 3 && (degrees30 + degrees25) >= 5){
				return true;
			}
		}

		return false;
	}

	// individual assignment Tiemen
	public Period longestDrougth() {
		ArrayList<Measurement> measurements = this.getMeasurements();
		int count = 0;
		int maxCount = 0;
		LocalDateTime endOfPeriod = null;
		LocalDateTime beginOfPeriod = null;
		for (int i = 0; i < measurements.size(); i++) {
			double totalRain = 0;
			if (measurements.get(i).getRainRate() < 10.0) {
				for (int j = i; j < measurements.size(); j++) {
					totalRain += measurements.get(j).getRainRate();
					if (totalRain >= 10)
						break;
					if (count > maxCount) {
						maxCount = count;
						endOfPeriod = measurements.get(j).getDateStamp();
						beginOfPeriod = measurements.get(i).getDateStamp();
					}
					count++;
				}
				count = 0;
			}
		}
		if (beginOfPeriod==null)
			return new Period();
		else
			return new Period(beginOfPeriod.toLocalDate(),endOfPeriod.toLocalDate());
    }

  	// individual assignment Erik
	public ArrayList<LocalDate> getGoodDays() {
		ArrayList<Measurement> measurements = getMeasurements();
		ArrayList<LocalDate> returnDagen = new ArrayList<>();
		for (Measurement measurement:measurements) {
			double temp = measurement.getOutsideTemp();
			int hum = measurement.getOutsideHum();
			double rainRate = measurement.getRainRate();

			if (temp > 22 && temp < 30) {
				if (hum > 30 && hum < 50) {
					if (rainRate == 0) {
						if (!returnDagen.contains(measurement.getDateStamp().toLocalDate())) {
							returnDagen.add(measurement.getDateStamp().toLocalDate());
						}
					}
				}
			}
		}
		return returnDagen;
	}
}
