import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        IO.init();
        GUI.clearSegment();
        GUI.clrDisplay();

//        First Row

//        IconDisplay.drawPicture("/Icons/Temp.png",10,3);
//        IconDisplay.drawPicture("/Icons/rainrate.png",26,3);
//        IconDisplay.drawPicture("/Icons/dewpoint.png",42,3);
//        IconDisplay.drawPicture("/Icons/wind.png",58,3);
//        IconDisplay.drawPicture("/Icons/heatindex.png",74,3);
//        IconDisplay.drawPicture("/Icons/sunrise.png",90,3);
//        IconDisplay.drawPicture("/Icons/batterylevel.png",106,3);
//
//      Second Row
//
//        IconDisplay.drawPicture("/Icons/heatindex.png",10,18);
//        IconDisplay.drawPicture("/Icons/Humidity.png",26,18);
//        IconDisplay.drawPicture("/Icons/barometer.png",42,18);
//        IconDisplay.drawPicture("/Icons/windchill.png",58,18);
//        IconDisplay.drawPicture("/Icons/UV.png",74,18);
//        IconDisplay.drawPicture("/Icons/sunset.png",90,18);

        Menu mainMenu = new Menu("mainMenu",1,7);
        mainMenu.addItem(new MenuItem("hum","icons/humidity"));
        mainMenu.addItem(new MenuItem("temp","icons/temp"));
        mainMenu.addItem(new MenuItem("wind","icons/wind"));
        mainMenu.addItem(new MenuItem("bar","icons/barometer"));
        mainMenu.addItem(new MenuItem("dew","icons/dewpoint"));
        mainMenu.addItem(new MenuItem("heat","icons/heatindex"));
        mainMenu.addItem(new MenuItem("rain","icons/rainrate"));

        mainMenu.addItem(new MenuItem("solar","icons/Solarrad"));
        mainMenu.addItem(new MenuItem("sunrise","icons/sunrise"));
        mainMenu.addItem(new MenuItem("sunset","icons/sunset"));
        mainMenu.addItem(new MenuItem("uv","icons/uv"));
        mainMenu.addItem(new MenuItem("chill","icons/windchill"));
        mainMenu.addItem(new MenuItem("period","icons/period"));
        mainMenu.addItem(new MenuItem("exit","icons/quit"));
        System.out.println(mainMenu.getItems().size());

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
        while (true) {
            if(Button.previousButtonPressed()){
                menus.getCurrentMenu().previousItem();
            } else if(Button.nextButtonPressed()){
                menus.getCurrentMenu().nextItem();
            }
            menus.getCurrentMenu().displayIcons(3, 3, 15);
        }


    }

}