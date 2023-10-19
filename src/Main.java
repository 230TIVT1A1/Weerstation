import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
//        RawMeasurement rawMeasurement = DatabaseConnection.getMostRecentMeasurement();
//        Measurement measurement = new Measurement(rawMeasurement);
//        System.out.println(measurement.getOutsideTemp());
//        System.out.println(measurement.getOutsideHum());
//        System.out.println(measurement.getInsideTemp());
//        IO.init();
//        GUI.clearSegment();
//        GUI.segmentNumber(measurement.getOutsideTemp(),0,"00.00");
//        GUI.segmentNumber(measurement.getOutsideHum(),1,"00");
//        GUI.segmentNumber(measurement.getInsideTemp(),2,"0.0");
//        Period period = new Period(7);
//        period.longestRainFall();
//        period.maxTemperatureDifference();
//        /**
//         Laagste
//         */
//        System.out.println("Laagste Binnentemperatuur: " + period.getLowestInsideTemp());
//        System.out.println("Laagste Buitentemperatuur: " + period.getLowestOutsideTemp());
//        System.out.println("Laagste Barometer: " + period.getLowestBarometer());
//        System.out.println("Laagste Luchtvochtigheid Buiten: " + period.getLowestOutsideHumidity());
//
//        System.out.println("---------------------------------------------");
//        /**
//         Hoogste
//         */
//        System.out.println("Hoogste Binnentemperatuur: " + period.getHighestInsideTemp());
//        System.out.println("Hoogste Buitentemperatuur: " + period.getHighestOutsideTemp());
//        System.out.println("Hoogste Barometer: " + period.getHighestBarometer());
//        System.out.println("Hoogste Luchtvochtigheid Buiten: " + period.getHighestOutsideHumidity());
//
//        System.out.println("---------------------------------------------");
//        /**
//         Gemiddelde
//         */
//        System.out.println("Gemiddelde Binnentemperatuur: " + period.getAverageInsideTemp());
//        System.out.println("Gemiddelde Buitentemperatuur: " + period.getAverageOutsideTemp());
//        System.out.println("Gemiddelde Barometer: " + period.getAverageBarometer());
//        System.out.println("Gemiddelde Luchtvochtigheid Buiten: " + period.getAverageOutsideHumidity());
//
//        System.out.println("---------------------------------------------");
//        /**
//         Mediaan
//         */
//        System.out.println("Mediaan Binnentemperatuur: " + period.getInsideTempMedian());
//        System.out.println("Mediaan Buitentemperatuur: " + period.getOutsideTempMedian());
//        System.out.println("Mediaan Barometer: " + period.getBarometerMedian());
//        System.out.println("Mediaan Luchtvochtigheid Buiten: " + period.getOutsideHumidityMedian());
//
//        System.out.println("---------------------------------------------");
//
//        /**
//         Modus
//         */
//        System.out.println("Mode Binnentemperatuur: " + period.getInsideTempMode());
//        System.out.println("Mode Buitentemperatuur: " + period.getOutsideTempMode());
//        System.out.println("Mode Barometer: " + period.getBarometerMode());
//        System.out.println("Mode Luchtvochtigheid Buiten: " + period.getOutsideHumidityMode());
//
//        System.out.println("---------------------------------------------");
//
//        /**
//         Standaardafwijking
//         */
//        System.out.println("Standaardafwijking Binnentemperatuur: " + period.getInsideTempSD());
//        System.out.println("Standaardafwijking Buitentemperatuur: " + period.getOutsideTempSD());
//        System.out.println("Standaardafwijking Barometer: " + period.getBarometerSD());
//        System.out.println("Standaardafwijking Luchtvochtigheid Buiten: " + period.getOutsideHumiditySD());
//
//        System.out.println("---------------------------------------------");
//
//        /**
//         Individual Assignment (Daan)
//         Date of biggest difference between the WindChill and OutsideTemp
//         */
//        System.out.println("Biggest difference between the WindChill and OutsideTemp: " + period.getDiffWindChillAndOutsideTemp());
//        System.out.println("Date when this happend: " + period.getDateBiggestDiff());


        Menu mainMenu = new Menu("mainMenu");
        mainMenu.addItem(new MenuItem("hum"));
        mainMenu.addItem(new MenuItem("temp"));
        mainMenu.addItem(new MenuItem("wind"));
        mainMenu.addItem(new MenuItem("bar"));
        mainMenu.addItem(new MenuItem("period"));

        Menu subMenu = new Menu("subMenu");
        subMenu.addItem(new MenuItem("modes"));
        subMenu.addItem(new MenuItem("mediaan"));
        subMenu.addItem(new MenuItem("standaardafwijking"));
        subMenu.addItem(new MenuItem("gemiddeld"));
        subMenu.addItem(new MenuItem("minimaal"));
        subMenu.addItem(new MenuItem("maximaal"));


        Menu periodMenu = new Menu("periodMenu");
        periodMenu.addItem(new MenuItem("Last year"));
        periodMenu.addItem(new MenuItem("Last month"));
        periodMenu.addItem(new MenuItem("Last week"));
        periodMenu.addItem(new MenuItem("Last Hour"));
        periodMenu.addItem(new MenuItem("This day"));
        periodMenu.addItem(new MenuItem("Yesterday"));

        ArrayList<Menu> menuArray = new ArrayList<>();
        menuArray.add(mainMenu);
        menuArray.add(subMenu);
        menuArray.add(periodMenu);

        Menus menus = new Menus(menuArray);



    }

}