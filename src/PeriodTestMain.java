import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PeriodTestMain {
	public static void main(String[] args) {

		Period period = new Period(7); // last week
		System.out.println(period.longestRainFall());
	}

}
