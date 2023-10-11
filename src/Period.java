import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
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
	 * @return a list of raw measurements
	 */
	public ArrayList<RawMeasurement> getRawMeasurements() {
		return DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(beginPeriod, LocalTime.of(0, 1)), LocalDateTime.of(endPeriod, LocalTime.of(23, 59)));
	}

	/**
	 * Builds an ArrayList of measurements. This method also filters out any 'bad' measurements
	 * @return a filtered list of measurements
	 */
	public ArrayList<Measurement> getMeasurements() {
		ArrayList<Measurement> measurements = new ArrayList<>();
		ArrayList<RawMeasurement> rawMeasurements = getRawMeasurements();
		for (RawMeasurement rawMeasurement : rawMeasurements) {
			Measurement measurement = new Measurement(rawMeasurement);
			if(measurement.isValid()) {
				measurements.add(measurement);
			}
		}
		return measurements;
	}


	/**
	 * todo
	 * @return
	 */

	/**
	 * Todo
	 */
	public ArrayList<Period> hasHeatWave() {
		return null;
	}

	/**
	 * Todo
	 */
	public Period longestDraught() {
		return new Period();
	}

	/**
	 * Todo more methods
	 */


	/**
	InsideTemp
	 */
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

	public Double getInsideTempDeviation(ArrayList<Measurement> measurements) {

		return null;
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


	/**
	 * Individueel
	 */
	public Double maxTemperatureDifference(ArrayList<Measurement> measurements) {

		if (measurements.isEmpty()) {
			return null;
		}

		double maxTemp = measurements.get(0).getOutsideTemp();
		double minTemp = measurements.get(0).getOutsideTemp();

		for (Measurement measurement : measurements) {
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



}
