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

   public ArrayList<String> longestRainFall() {
       ArrayList<Measurement> arrayMesurement = getMeasurements();
       ArrayList<String> returnList = new ArrayList<>();
       LocalDateTime startDate = this.beginPeriod.atStartOfDay();
       LocalDateTime endDate = null;
       long longestRain = 0;
       for (Measurement mes : arrayMesurement) {
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

	/**
	InsideTemp
	 */
	public Double getLowestInsideTemp() {
		Measurement first = getMeasurements().get(0);
		double lowest = first.getInsideTemp();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getInsideTemp() < lowest) {
				lowest = measurement.getInsideTemp();
			}
		}
		return lowest;
	}

	public Double getHighestInsideTemp() {
		Measurement first = getMeasurements().get(0);
		double highest = first.getInsideTemp();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getInsideTemp() > highest) {
				highest = measurement.getInsideTemp();
			}
		}
		return highest;
	}

	public Double getAverageInsideTemp() {
		double sum = 0;
		for (Measurement measurement : getMeasurements()) {
			sum += measurement.getInsideTemp();
		}
		return sum / getMeasurements().size();
	}

	public Double getInsideTempMedian() {
		ArrayList<Double> insideTemps = new ArrayList<>();
		for (Measurement measurement : getMeasurements()) {
			insideTemps.add(measurement.getInsideTemp());
		}
		Collections.sort(insideTemps);
		int middle = (insideTemps.size() + 1) / 2;

		return insideTemps.get(middle);
	}

	public Double getInsideTempDeviation(ArrayList<Measurement> measurements) {

		return null;
	}

	/**
	OutsideTemp
	 */
	public Double getLowestOutsideTemp() {
		Measurement first = getMeasurements().get(0);
		double lowest = first.getOutsideTemp();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getOutsideTemp() < lowest) {
				lowest = measurement.getOutsideTemp();
			}
		}
		return lowest;
	}

	public Double getHighestOutsideTemp() {
		Measurement first = getMeasurements().get(0);
		double highest = first.getOutsideTemp();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getOutsideTemp() > highest) {
				highest = measurement.getOutsideTemp();
			}
		}
		return highest;
	}

	public Double getAverageOutsideTemp() {
		double sum = 0;
		for (Measurement measurement : getMeasurements()) {
			sum += measurement.getOutsideTemp();
		}
		return sum / getMeasurements().size();
	}

	public Double getOutsideTempMedian() {
		ArrayList<Double> outsideTemps = new ArrayList<>();
		for (Measurement measurement : getMeasurements()) {
			outsideTemps.add(measurement.getOutsideTemp());
		}
		Collections.sort(outsideTemps);
		int middle = (outsideTemps.size() + 1) / 2;

		return outsideTemps.get(middle);
	}

	/**
	Barometer
	 */
	public Double getLowestBarometer() {
		Measurement first = getMeasurements().get(0);
		double lowest = first.getBarometer();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getBarometer() < lowest) {
				lowest = measurement.getBarometer();
			}
		}
		return lowest;
	}

	public Double getHighestBarometer() {
		Measurement first = getMeasurements().get(0);
		double highest = first.getBarometer();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getBarometer() > highest) {
				highest = measurement.getBarometer();
			}
		}
		return highest;
	}

	public Double getAverageBarometer() {
		double sum = 0;
		for (Measurement measurement : getMeasurements()) {
			sum += measurement.getBarometer();
		}
		return sum / getMeasurements().size();
	}

	public Double getBarometerMedian() {
		ArrayList<Double> baros = new ArrayList<>();
		for (Measurement measurement : getMeasurements()) {
			baros.add(measurement.getBarometer());
		}
		Collections.sort(baros);
		int middle = (baros.size() + 1) / 2;

		return baros.get(middle);
	}

	/**
	Humidity
	 */
	public Integer getLowestOutsideHumidity() {
		Measurement first = getMeasurements().get(0);
		int lowest = first.getOutsideHum();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getOutsideHum() < lowest) {
				lowest = measurement.getOutsideHum();
			}
		}
		return lowest;
	}

	public Integer getHighestOutsideHumidity() {
		Measurement first = getMeasurements().get(0);
		int highest = first.getOutsideHum();
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getOutsideHum() > highest) {
				highest = measurement.getOutsideHum();
			}
		}
		return highest;
	}

	public Double getAverageOutsideHumidity() {
		int sum = 0;
		for (Measurement measurement : getMeasurements()) {
			sum += measurement.getOutsideHum();
		}
		return ((1.0*sum) / getMeasurements().size());
	}

	public Integer getOutsideHumidityMedian() {
		ArrayList<Integer> hums = new ArrayList<>();
		for (Measurement measurement : getMeasurements()) {
			hums.add(measurement.getOutsideHum());
		}
		Collections.sort(hums);
		int middle = (hums.size() + 1) / 2;

		return hums.get(middle);
	}


	/**
	 * Individueel
	 */
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

		double difference = maxTemp - minTemp;
		return difference;
	}

	public Double getLowestInsideTemp(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		double lowest = first.getInsideTemp();
		for (Measurement measurement : measurements) {
			if (measurement.getInsideTemp() < lowest) {
				lowest = measurement.getInsideTemp();
			}
		}
		return lowest;
	}

	public Double getHighestInsideTemp(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		double highest = first.getInsideTemp();
		for (Measurement measurement : measurements) {
			if (measurement.getInsideTemp() > highest) {
				highest = measurement.getInsideTemp();
			}
		}
		return highest;
	}

	public Double getAverageInsideTemp(ArrayList<Measurement> measurements) {
		double sum = 0;
		for (Measurement measurement : measurements) {
			sum += measurement.getInsideTemp();
		}
		return sum / measurements.size();
	}

	public Double getInsideTempMedian(ArrayList<Measurement> measurements) {
		ArrayList<Double> insideTemps = new ArrayList<>();
		for (Measurement measurement : measurements) {
			insideTemps.add(measurement.getInsideTemp());
		}
		Collections.sort(insideTemps);
		int middle = (insideTemps.size() + 1) / 2;

		return insideTemps.get(middle);
	}

	public Double getInsideTempMode(ArrayList<Measurement> measurements) {
		ArrayList<Double> insideTemps = new ArrayList<>();
		for (Measurement measurement : measurements) {
			insideTemps.add(measurement.getInsideTemp());
		}
		int maxFrequenty = 0;
		double insideTempMode = 0.0;
		for (int i = 0; i < insideTemps.size(); i++) {
			int count = 0;
			for (int j = 0; j < insideTemps.size(); j++) {
				if (Math.round(insideTemps.get(i)) == Math.round(insideTemps.get(j))) {
					count++;
				}

				if (count > maxFrequenty) {
					maxFrequenty = count;
					insideTempMode = Math.round(insideTemps.get(i));
				}
			}
		}
		return insideTempMode;
	}

	public Double getInsideTempSD(ArrayList<Measurement> measurements) {
		ArrayList<Double> insideTemps = new ArrayList<>();
		for (Measurement measurement : measurements) {
			insideTemps.add(measurement.getInsideTemp());
		}
		double dividend = 0.0;
		double averageInsideTemp = this.getAverageInsideTemp(measurements);
		for (Double insideTemp : insideTemps) {
			dividend += (insideTemp - averageInsideTemp) * (insideTemp - averageInsideTemp);
		}
		return Math.sqrt(dividend/(insideTemps.size()-1));
	}

	/**
	 OutsideTemp
	 */
	public Double getLowestOutsideTemp(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		double lowest = first.getOutsideTemp();
		for (Measurement measurement : measurements) {
			if (measurement.getOutsideTemp() < lowest) {
				lowest = measurement.getOutsideTemp();
			}
		}
		return lowest;
	}

	public Double getHighestOutsideTemp(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		double highest = first.getOutsideTemp();
		for (Measurement measurement : measurements) {
			if (measurement.getOutsideTemp() > highest) {
				highest = measurement.getOutsideTemp();
			}
		}
		return highest;
	}

	public Double getAverageOutsideTemp(ArrayList<Measurement> measurements) {
		double sum = 0;
		for (Measurement measurement : measurements) {
			sum += measurement.getOutsideTemp();
		}
		return sum / measurements.size();
	}

	public Double getOutsideTempMedian(ArrayList<Measurement> measurements) {
		ArrayList<Double> outsideTemps = new ArrayList<>();
		for (Measurement measurement : measurements) {
			outsideTemps.add(measurement.getOutsideTemp());
		}
		Collections.sort(outsideTemps);
		int middle = (outsideTemps.size() + 1) / 2;

		return outsideTemps.get(middle);
	}

	public Double getOutsideTempMode(ArrayList<Measurement> measurements) {
		ArrayList<Double> outsideTemps = new ArrayList<>();
		for (Measurement measurement : measurements) {
			outsideTemps.add(measurement.getOutsideTemp());
		}
		int maxFrequenty = 0;
		double outsideTempMode = 0.0;
		for (int i = 0; i < outsideTemps.size(); i++) {
			int count = 0;
			for (int j = 0; j < outsideTemps.size(); j++) {
				if (Math.round(outsideTemps.get(i)) == Math.round(outsideTemps.get(j))) {
					count++;
				}

				if (count > maxFrequenty) {
					maxFrequenty = count;
					outsideTempMode = Math.round(outsideTemps.get(i));
				}
			}
		}
		return outsideTempMode;
	}

	public Double getOutsideTempSD(ArrayList<Measurement> measurements) {
		ArrayList<Double> outsideTemps = new ArrayList<>();
		for (Measurement measurement : measurements) {
			outsideTemps.add(measurement.getOutsideTemp());
		}
		double dividend = 0.0;
		double averageOutsideTemp = this.getAverageOutsideTemp(measurements);
		for (Double outsideTemp : outsideTemps) {
			dividend += (outsideTemp - averageOutsideTemp) * (outsideTemp - averageOutsideTemp);
		}
		return Math.sqrt(dividend/(outsideTemps.size()-1));
	}

	/**
	 Barometer
	 */
	public Double getLowestBarometer(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		double lowest = first.getBarometer();
		for (Measurement measurement : measurements) {
			if (measurement.getBarometer() < lowest) {
				lowest = measurement.getBarometer();
			}
		}
		return lowest;
	}

	public Double getHighestBarometer(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		double highest = first.getBarometer();
		for (Measurement measurement : measurements) {
			if (measurement.getBarometer() > highest) {
				highest = measurement.getBarometer();
			}
		}
		return highest;
	}

	public Double getAverageBarometer(ArrayList<Measurement> measurements) {
		double sum = 0;
		for (Measurement measurement : measurements) {
			sum += measurement.getBarometer();
		}
		return sum / measurements.size();
	}

	public Double getBarometerMedian(ArrayList<Measurement> measurements) {
		ArrayList<Double> baros = new ArrayList<>();
		for (Measurement measurement : measurements) {
			baros.add(measurement.getBarometer());
		}
		Collections.sort(baros);
		int middle = (baros.size() + 1) / 2;

		return baros.get(middle);
	}

	public Double getBarometerMode(ArrayList<Measurement> measurements) {
		ArrayList<Double> Barometer = new ArrayList<>();
		for (Measurement measurement : measurements) {
			Barometer.add(measurement.getBarometer());
		}
		int maxFrequenty = 0;
		double barometerMode = 0.0;
		for (int i = 0; i < Barometer.size(); i++) {
			int count = 0;
			for (int j = 0; j < Barometer.size(); j++) {
				if (Math.round(Barometer.get(i)) == Math.round(Barometer.get(j))) {
					count++;
				}

				if (count > maxFrequenty) {
					maxFrequenty = count;
					barometerMode = Math.round(Barometer.get(i));
				}
			}
		}
		return barometerMode;
	}

	public Double getBarometerSD(ArrayList<Measurement> measurements) {
		ArrayList<Double> Barometers = new ArrayList<>();
		for (Measurement measurement : measurements) {
			Barometers.add(measurement.getBarometer());
		}
		double dividend = 0.0;
		double averageBarometer = this.getAverageBarometer(measurements);
		for (Double barometer : Barometers) {
			dividend += (barometer - averageBarometer) * (barometer - averageBarometer);
		}
		return Math.sqrt(dividend/(Barometers.size()-1));
	}

	/**
	 Humidity
	 */
	public Integer getLowestOutsideHumidity(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		int lowest = first.getOutsideHum();
		for (Measurement measurement : measurements) {
			if (measurement.getOutsideHum() < lowest) {
				lowest = measurement.getOutsideHum();
			}
		}
		return lowest;
	}

	public Integer getHighestOutsideHumidity(ArrayList<Measurement> measurements) {
		Measurement first = measurements.get(0);
		int highest = first.getOutsideHum();
		for (Measurement measurement : measurements) {
			if (measurement.getOutsideHum() > highest) {
				highest = measurement.getOutsideHum();
			}
		}
		return highest;
	}

	public Double getAverageOutsideHumidity(ArrayList<Measurement> measurements) {
		int sum = 0;
		for (Measurement measurement : measurements) {
			sum += measurement.getOutsideHum();
		}
		return ((1.0*sum) / measurements.size());
	}

	public Integer getOutsideHumidityMedian(ArrayList<Measurement> measurements) {
		ArrayList<Integer> hums = new ArrayList<>();
		for (Measurement measurement : measurements) {
			hums.add(measurement.getOutsideHum());
		}
		Collections.sort(hums);
		int middle = (hums.size() + 1) / 2;

		return hums.get(middle);
	}

	public Double getOutsideHumidityMode(ArrayList<Measurement> measurements) {
		ArrayList<Integer> Humidities = new ArrayList<>();
		for (Measurement measurement : measurements) {
			Humidities.add(measurement.getOutsideHum());
		}
		int maxFrequenty = 0;
		double humidityMode = 0.0;
		for (int i = 0; i < Humidities.size(); i++) {
			int count = 0;
			for (int j = 0; j < Humidities.size(); j++) {
				if (Humidities.get(i) == Humidities.get(j)) {
					count++;
				}

				if (count > maxFrequenty) {
					maxFrequenty = count;
					humidityMode = Humidities.get(i);
				}
			}
		}
		return humidityMode;
	}

	public Double getOutsideHumiditySD(ArrayList<Measurement> measurements) {
		ArrayList<Integer> Humidities = new ArrayList<>();
		for (Measurement measurement : measurements) {
			Humidities.add(measurement.getOutsideHum());
		}
		double dividend = 0.0;
		double averageOutsideHumidity = this.getAverageOutsideHumidity(measurements);
		for (int humidity : Humidities) {
			dividend += (humidity - averageOutsideHumidity) * (humidity - averageOutsideHumidity);
		}
		return Math.sqrt(dividend/(Humidities.size()-1));
	}


	/**
	 * Individueel
	 */
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
