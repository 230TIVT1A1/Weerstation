import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PeriodTestMain {
	public static void main(String[] args){

		Period period = new Period(7); // last week
//
//		System.out.println("The average temperature of last week was " + period.getAverageOutsideTemperature());

		ArrayList<LocalDate> test = period.getGoodDays();
		System.out.println(test);
	}

}
