import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GetDataForDisplay {

    private MenuItem menu;

    // possibly other var name, usage for average, median, mode, etc.
    private MenuItem format;
    private Period period;


    public GetDataForDisplay(MenuItem menu, MenuItem format, Period period) {
        this.menu = menu;
        this.format = format;
        this.period = period;

        GUI.clearSegment();
        sendToGUI();
        IO.delay(500);

    }

    private void sendToGUI() {
        if (format.getName().equalsIgnoreCase("modus")){
            if (menu.getName().equalsIgnoreCase("hum")){
                Double aHum = period.getOutsideHumidityMode();
                GUI.segmentNumber(aHum, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("temp")){
                Double aTemp = period.getOutsideTempMode();
                GUI.segmentNumber(aTemp, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("bar")){
                Double aBar = period.getBarometerMode();
                GUI.segmentNumber(aBar, 0, "0000.0");
            }
        } else if (format.getName().equalsIgnoreCase("mediaan")){
            if (menu.getName().equalsIgnoreCase("hum")){
                int aHum = period.getOutsideHumidityMedian();
                GUI.segmentNumber(aHum, 0, "00");
            } else if (menu.getName().equalsIgnoreCase("temp")){
                Double aTemp = period.getOutsideTempMedian();
                GUI.segmentNumber(aTemp, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("bar")){
                Double aBar = period.getBarometerMedian();
                GUI.segmentNumber(aBar, 0, "0000.0");
            }
        } else if (format.getName().equalsIgnoreCase("standaardafwijking")){
            if (menu.getName().equalsIgnoreCase("hum")){
                Double aHum = period.getOutsideHumiditySD();
                GUI.segmentNumber(aHum, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("temp")){
                Double aTemp = period.getOutsideTempSD();
                GUI.segmentNumber(aTemp, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("bar")){
                Double aBar = period.getBarometerSD();
                GUI.segmentNumber(aBar, 0, "0000.0");
            }
        } else if (format.getName().equalsIgnoreCase("gemiddeld")){
            if (menu.getName().equalsIgnoreCase("hum")){
                Double aHum = period.getAverageOutsideHumidity();
                GUI.segmentNumber(aHum, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("temp")){
                Double aTemp = period.getAverageOutsideTemp();
                GUI.segmentNumber(aTemp, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("bar")){
                Double aBar = period.getAverageBarometer();
                GUI.segmentNumber(aBar, 0, "0000.0");
            }
        } else if (format.getName().equalsIgnoreCase("minimaal")){
            if (menu.getName().equalsIgnoreCase("hum")){
                int aHum = period.getLowestOutsideHumidity();
                GUI.segmentNumber(aHum, 0, "00");
            } else if (menu.getName().equalsIgnoreCase("temp")){
                Double aTemp = period.getLowestOutsideTemp();
                GUI.segmentNumber(aTemp, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("bar")){
                Double aBar = period.getLowestBarometer();
                GUI.segmentNumber(aBar, 0, "00.0");
            }
        } else if (format.getName().equalsIgnoreCase("maximaal")){
            if (menu.getName().equalsIgnoreCase("hum")){
                int aHum = period.getHighestOutsideHumidity();
                GUI.segmentNumber(aHum, 0, "00");
            } else if (menu.getName().equalsIgnoreCase("temp")){
                Double aTemp = period.getHighestOutsideTemp();
                GUI.segmentNumber(aTemp, 0, "00.0");
            } else if (menu.getName().equalsIgnoreCase("bar")){
                Double aBar = period.getHighestBarometer();
                GUI.segmentNumber(aBar, 0, "00.0");
            }
        }
    }

    public GetDataForDisplay(MenuItem individualAssignment, Period period){
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
