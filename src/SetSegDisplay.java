import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SetSegDisplay {

    public SetSegDisplay(MenuItem menu, MenuItem calculation, Period period) {
        GUI.clearSegment();

//        switch(menu.getName().equalsIgnoreCase("temp")) {

//        } else {
//            double data = period.calculatePeriod(calculation.getName(), menu.getName());
//            GUI.segmentNumber(data, 0, "0.0");
//        }

        switch(menu.getName()) {
            case "temp":
                double outtemp = period.calculatePeriod(calculation.getName(), "outtemp");
                double intemp = period.calculatePeriod(calculation.getName(), "intemp");

                GUI.segmentNumber(outtemp, 1, "0.0");
                GUI.segmentNumber(intemp, 2, "0.0");
                break;
            case "sunrise":

                break;
            case "sunset":

                break;
            default:
                double data = period.calculatePeriod(calculation.getName(), menu.getName());
                GUI.segmentNumber(data, 0, "0.0");
        }

        IO.delay(500);

        }


    public SetSegDisplay(MenuItem individualAssignment, Period period){
        GUI.clearSegment();

        switch(individualAssignment.getName()) {
            case "Assignment Daan":
                double windDifference = period.getDiffWindChillAndOutsideTemp();
                LocalDate date = period.getDateBiggestDiff();
                String sDate = String.valueOf(date);
                int pos1 = sDate.indexOf('-');
                int pos2 = sDate.lastIndexOf('-');
                GUI.segmentNumber(windDifference, 0, "00.0");
                GUI.segmentNumber(Double.parseDouble(sDate.substring(pos1+1, pos2)), 2, "00");
                GUI.segmentNumber(Double.parseDouble(sDate.substring(pos2+1)), 1, "00");
                break;
            case "Assignment Storm":
                ArrayList<String> rainfall = period.longestRainFall();
                int longestRainFall = Integer.parseInt(rainfall.get(0));
                LocalDateTime start = LocalDateTime.parse(rainfall.get(1));
                LocalDateTime end = LocalDateTime.parse(rainfall.get(2));
                GUI.segmentNumber(longestRainFall, 0 , "000.0");
                break;
            case "Assignment Melvin":
                double tempDifference = period.maxTemperatureDifference();
                GUI.segmentNumber(tempDifference, 0, "00.0" );
                break;
            case "Assignment Tiemen":
                Period Drought = period.longestDrougth();
                String startDrought = String.valueOf(Drought.getBeginPeriod());
                int startPos1 = startDrought.indexOf('-');
                int startPos2 = startDrought.lastIndexOf('-');
                double startDate = (Double.parseDouble(startDrought.substring(startPos2 + 1))) + (Double.parseDouble(startDrought.substring(startPos1 + 1, startPos2)) / 100);
                GUI.segmentNumber(startDate, 0, "00.00");

                String endDrought = String.valueOf(Drought.getEndPeriod());
                int endPos1 = endDrought.indexOf('-');
                int endPos2 = endDrought.lastIndexOf('-');
                GUI.segmentNumber(Double.parseDouble(endDrought.substring(endPos1+1, endPos2)), 2, "00");
                GUI.segmentNumber(Double.parseDouble(endDrought.substring(endPos2+1)), 1, "00");
                break;
            case "Assignment Erik":
                ArrayList<LocalDate> goodDays = period.getGoodDays();
                double amountOfDays = goodDays.size();
                GUI.segmentNumber(amountOfDays, 0, "000");
                break;
            case "Assignment Lucas":
                boolean Heatwave = period.Heatwave();
                if (Heatwave) { GUI.segmentNumber(1, 0, "0");
                } else { GUI.segmentNumber(0, 0, "0"); }
                break;
        }

        IO.delay(500);
    }
}
