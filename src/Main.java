import java.util.ArrayList;
public class Main {
    public static boolean run = true;
    public static volatile boolean periodSelected = false;
    public static Period selectedPeriod = new Period();
    public static MenuItem mainMenuSelected = new MenuItem();

    public static void main(String[] args) {
        IO.init();
        GUI.clearSegment();
        GUI.clrDisplay();


        // Declare menus
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

        Menus menus = new Menus(menuArray);


        // Program code
        while (run) {
            // Get current menu and item
            Menu selectedMenu = menus.getCurrentMenu();
            MenuItem selected = menus.getCurrentMenu().getCurrentItem();

// live homescreen?
//            if (!periodSelected) {
//                GUI.clearSegment();
//                Period period = new Period();
//                double outsideTemp = period.getHighestOutsideTemp();
//                double outsideHumidity = period.getHighestOutsideHumidity();
//                double windSpeed = period.getHighestWindSpeed();
//
//                GUI.segmentNumber(outsideTemp, 0, "00.0");
//                GUI.segmentNumber(outsideHumidity, 1, "00");
//                GUI.segmentNumber(windSpeed, 2, "0.0");
//            }

            // Buttons
            if(Button.previousButtonPressed()){
                // Previous item
                // Main menu
                if (selectedMenu.getName().equalsIgnoreCase("mainMenu")){
                    if (selected.getName().equalsIgnoreCase("hum")){
                        menus.getCurrentMenu().setCurrentItem("exit");
                        IO.delay(300);
                    } else{
                        menus.getCurrentMenu().previousItem();
                        IO.delay(300);
                    }
                }
                // Sub menu
                else if (selectedMenu.getName().equalsIgnoreCase("subMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        menus.getCurrentMenu().setCurrentItem("maximaal");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().previousItem();
                        IO.delay(300);
                    }
                }
                // Extra menu
                else if (selectedMenu.getName().equalsIgnoreCase("extraMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        menus.getCurrentMenu().setCurrentItem("assignments");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().previousItem();
                        IO.delay(300);
                    }
                }
                // Period menu
                else if (selectedMenu.getName().equalsIgnoreCase("periodMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        menus.getCurrentMenu().setCurrentItem("yesterday");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().previousItem();
                        IO.delay(300);
                    }
                }
                // Assignments menu
                else if (selectedMenu.getName().equalsIgnoreCase("assignmentsMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        menus.getCurrentMenu().setCurrentItem("assignment lucas");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().previousItem();
                        IO.delay(300);
                    }
                }
            } else if(Button.nextButtonPressed()){
                // Next item
                // Main menu
                if (selectedMenu.getName().equalsIgnoreCase("mainMenu")){
                    if (selected.getName().equalsIgnoreCase("exit")){
                        menus.getCurrentMenu().setCurrentItem("hum");
                        IO.delay(300);
                    } else{
                        menus.getCurrentMenu().nextItem();
                        IO.delay(300);
                    }
                }
                // Sub menu
                else if (selectedMenu.getName().equalsIgnoreCase("subMenu")){
                    if (selected.getName().equalsIgnoreCase("maximaal")){
                        menus.getCurrentMenu().setCurrentItem("back");
                        IO.delay(300);
                    } else{
                        menus.getCurrentMenu().nextItem();
                        IO.delay(300);
                    }
                }
                // Extra menu
                else if (selectedMenu.getName().equalsIgnoreCase("extraMenu")){
                    if (selected.getName().equalsIgnoreCase("assignments")){
                        menus.getCurrentMenu().setCurrentItem("back");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().nextItem();
                        IO.delay(300);
                    }
                }
                // Period menu
                else if (selectedMenu.getName().equalsIgnoreCase("periodMenu")){
                    if (selected.getName().equalsIgnoreCase("yesterday")){
                        menus.getCurrentMenu().setCurrentItem("back");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().nextItem();
                        IO.delay(300);
                    }
                }
                // Assignments menu
                else if (selectedMenu.getName().equalsIgnoreCase("assignmentsMenu")){
                    if (selected.getName().equalsIgnoreCase("assignment lucas")){
                        menus.getCurrentMenu().setCurrentItem("back");
                        IO.delay(300);
                    } else {
                        menus.getCurrentMenu().nextItem();
                        IO.delay(300);
                    }
                }
            }else if(Button.selectButtonPressed()){
                // Select item
                // Main menu
                if (selectedMenu.getName().equalsIgnoreCase("mainMenu")){
                    mainMenuSelected = selected;
                    if (selected.getName().equalsIgnoreCase("exit")){
                        // Exit
                        run = false;
                    } else if (selected.getName().equalsIgnoreCase("extra")){
                        // Period & assignments
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        IO.delay(500);
                    } else {
                        // subMenu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("subMenu");
                        IO.delay(500);
                    }
                }
                // Sub menu
                else if (selectedMenu.getName().equalsIgnoreCase("subMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("mainMenu");
                        IO.delay(500);
                    } else{
                        // Statistic selected
                        if (periodSelected){
                            new SetSegDisplay(mainMenuSelected, selected, selectedPeriod);
                        }
                    }
                }
                // Extra menu
                else if (selectedMenu.getName().equalsIgnoreCase("extraMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("mainMenu");
                        IO.delay(500);
                    } else if (selected.getName().equalsIgnoreCase("period")){
                        // Period menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("periodMenu");
                        IO.delay(500);
                    } else if (selected.getName().equalsIgnoreCase("assignments")){
                        // Assignments menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("assignmentsMenu");
                        IO.delay(500);
                    }
                }
                // Period menu
                else if (selectedMenu.getName().equalsIgnoreCase("periodMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        IO.delay(500);
                    } else {
                        // Period selected (Nog te veranderen!)
                        if (selected.getName().equalsIgnoreCase("last year")){
                            Period period = new Period(365);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("last month")){
                            Period period = new Period(30);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("last week")){
                            Period period = new Period(14);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("last hour")){
                            // Het laatste uur is geen LocalDateTime, maar een LocalDate!
                            // Dit moet met de DatabaseConnection gebeuren?
                            //DatabaseConnection.getMeasurementsLastHour();
                            Period period = new Period(0);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("today")){
                            Period period = new Period(0);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("yesterday")){
                            Period period = new Period(1);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("now")){
                            Period period = new Period();
                            periodSelected = true;
                            selectedPeriod = period;
                        }

                    }
                }
                // Assignments menu
                else if (selectedMenu.getName().equalsIgnoreCase("assignmentsMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        IO.delay(500);
                    } else if (periodSelected){
                        new SetSegDisplay(selected, selectedPeriod);
                    }

                }
            }
            // Show icons
            menus.getCurrentMenu().displayIcons(3, 3, 15);
        }
        // When quit, clear the entire display
        GUI.clearSegment();
        GUI.clrDisplay();
    }
}