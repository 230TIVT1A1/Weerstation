import java.util.ArrayList;

public class MenuInit {

    public static Menus start() {
        Menu mainMenu = new Menu("mainMenu",2,7);
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
        mainMenu.addItem(new MenuItem("extra","icons/period"));
        mainMenu.addItem(new MenuItem("exit","icons/quit"));

        Menu subMenu = new Menu("subMenu", 1, 7);
        subMenu.addItem(new MenuItem("back","icons/back"));
        subMenu.addItem(new MenuItem("modus","icons/submenu/modus"));
        subMenu.addItem(new MenuItem("mediaan","icons/submenu/mediaan"));
        subMenu.addItem(new MenuItem("standaardafwijking","icons/submenu/standaardafwijking"));
        subMenu.addItem(new MenuItem("gemiddeld","icons/submenu/gemiddelde"));
        subMenu.addItem(new MenuItem("minimaal","icons/submenu/minimaal"));
        subMenu.addItem(new MenuItem("maximaal","icons/submenu/maximaal"));

        Menu extraMenu = new Menu("extraMenu", 1, 3);
        extraMenu.addItem(new MenuItem("back","icons/back"));
        extraMenu.addItem(new MenuItem("period", "icons/extramenu/periode"));
        extraMenu.addItem(new MenuItem("assignments", "icons/extramenu/assignments"));

        Menu periodMenu = new Menu("periodMenu", 1, 7);
        periodMenu.addItem(new MenuItem("back","icons/back"));
        periodMenu.addItem(new MenuItem("Last year","icons/periodmenu/lastyear"));
        periodMenu.addItem(new MenuItem("Last month","icons/periodmenu/lastmonth"));
        periodMenu.addItem(new MenuItem("Last week","icons/periodmenu/lastweek"));
        periodMenu.addItem(new MenuItem("Last Hour","icons/periodmenu/lasthour"));
        periodMenu.addItem(new MenuItem("This day","icons/periodmenu/today"));
        periodMenu.addItem(new MenuItem("Yesterday","icons/periodmenu/yesterday"));

        Menu assignmentsMenu = new Menu("assignmentsMenu",1,7);
        assignmentsMenu.addItem(new MenuItem("back","icons/back"));
        assignmentsMenu.addItem(new MenuItem("Assignment Daan","icons/assignment/daan"));
        assignmentsMenu.addItem(new MenuItem("Assignment Storm","icons/assignment/storm"));
        assignmentsMenu.addItem(new MenuItem("Assignment Melvin","icons/assignment/melvin"));
        assignmentsMenu.addItem(new MenuItem("Assignment Tiemen","icons/assignment/tiemen"));
        assignmentsMenu.addItem(new MenuItem("Assignment Erik","icons/assignment/erik"));
        assignmentsMenu.addItem(new MenuItem("Assignment Lucas","icons/assignment/lucas"));

        ArrayList<Menu> menuArray = new ArrayList<>();
        menuArray.add(mainMenu);
        menuArray.add(subMenu);
        menuArray.add(extraMenu);
        menuArray.add(periodMenu);
        menuArray.add(assignmentsMenu);

       return new Menus(menuArray);
    }
}
