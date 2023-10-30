import java.util.ArrayList;

public class PeriodSelect {
    public static Period selectedPeriod = null;
    public static boolean isSelected = false;

    private int year = 365;
    private int month = 30;
    private int week = 7;
    private int yesterday = 1;
    private int today = 0;

    public PeriodSelect(String time) {
        switch(time) {
            case "last year":
                selectedPeriod = new Period(year);
                break;
            case "last month":
                selectedPeriod = new Period(month);
                break;
            case "last week":
                selectedPeriod = new Period(week);
                break;
            case "yesterday":
                selectedPeriod = new Period(yesterday);
                break;
            case "today":
                selectedPeriod = new Period(today);
                break;
            case "now":
                selectedPeriod = new Period();
                break;
        }
        if(selectedPeriod != null)isSelected = true;
    }
}
