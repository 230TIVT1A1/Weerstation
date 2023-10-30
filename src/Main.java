import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static boolean run = true;
    public static boolean periodSelected = false;
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

        Menu extraMenu = new Menu("extraMenu", 1, 3);
        extraMenu.addItem(new MenuItem("back","icons/back"));
        extraMenu.addItem(new MenuItem("period", "icons/periode"));
        extraMenu.addItem(new MenuItem("assignments", "icons/assignments"));

        Menu subMenu = new Menu("subMenu", 1, 7);
        subMenu.addItem(new MenuItem("back","icons/back"));
        subMenu.addItem(new MenuItem("modus","icons/modus"));
        subMenu.addItem(new MenuItem("mediaan","icons/mediaan"));
        subMenu.addItem(new MenuItem("standaardafwijking","icons/standaardafwijking"));
        subMenu.addItem(new MenuItem("gemiddeld","icons/gemiddelde"));
        subMenu.addItem(new MenuItem("minimaal","icons/minimaal"));
        subMenu.addItem(new MenuItem("maximaal","icons/maximaal"));

        Menu periodMenu = new Menu("periodMenu", 1, 7);
        periodMenu.addItem(new MenuItem("back","icons/back"));
        periodMenu.addItem(new MenuItem("Last year","icons/lastyear"));
        periodMenu.addItem(new MenuItem("Last month","icons/lastmonth"));
        periodMenu.addItem(new MenuItem("Last week","icons/lastweek"));
        periodMenu.addItem(new MenuItem("Last Hour","icons/lasthour"));
        periodMenu.addItem(new MenuItem("This day","icons/thisday"));
        periodMenu.addItem(new MenuItem("Yesterday","icons/yesterday"));

        Menu assignmentsMenu = new Menu("assignmentsMenu",1,7);
        assignmentsMenu.addItem(new MenuItem("back","icons/back"));
        assignmentsMenu.addItem(new MenuItem("Assignment Daan","icons/assignmentdaan"));
        assignmentsMenu.addItem(new MenuItem("Assignment Storm","icons/assignmentstorm"));
        assignmentsMenu.addItem(new MenuItem("Assignment Melvin","icons/assignmentmelvin"));
        assignmentsMenu.addItem(new MenuItem("Assignment Tiemen","icons/assignmenttiemen"));
        assignmentsMenu.addItem(new MenuItem("Assignment Erik","icons/assignmenterik"));
        assignmentsMenu.addItem(new MenuItem("Assignment Lucas","icons/assignmentlucas"));

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
                        // Period
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        IO.delay(500);
                    } else if (selected.getName().equalsIgnoreCase("wind")){
                        // Show recent wind
                        RawMeasurement recent = DatabaseConnection.getMostRecentMeasurement();
                        double windSpeed = recent.getWindSpeed();
                        GUI.segmentNumber(windSpeed, 0, "00.0");
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
                            if (selected.getName().equalsIgnoreCase("modus")){
                                if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                    GUI.clearSegment();
                                    Double aHum = selectedPeriod.getOutsideHumidityMode();
                                    GUI.segmentNumber(aHum, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                    GUI.clearSegment();
                                    Double aTemp = selectedPeriod.getOutsideTempMode();
                                    GUI.segmentNumber(aTemp, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                    GUI.clearSegment();
                                    Double aBar = selectedPeriod.getBarometerMode();
                                    GUI.segmentNumber(aBar, 0, "0000.0");
                                    IO.delay(500);
                                }
                            } else if (selected.getName().equalsIgnoreCase("mediaan")){
                                if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                    GUI.clearSegment();
                                    int aHum = selectedPeriod.getOutsideHumidityMedian();
                                    GUI.segmentNumber(aHum, 0, "00");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                    GUI.clearSegment();
                                    Double aTemp = selectedPeriod.getOutsideTempMedian();
                                    GUI.segmentNumber(aTemp, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                    GUI.clearSegment();
                                    Double aBar = selectedPeriod.getBarometerMedian();
                                    GUI.segmentNumber(aBar, 0, "0000.0");
                                    IO.delay(500);
                                }
                            } else if (selected.getName().equalsIgnoreCase("standaardafwijking")){
                                if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                    GUI.clearSegment();
                                    Double aHum = selectedPeriod.getOutsideHumiditySD();
                                    GUI.segmentNumber(aHum, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                    GUI.clearSegment();
                                    Double aTemp = selectedPeriod.getOutsideTempSD();
                                    GUI.segmentNumber(aTemp, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                    GUI.clearSegment();
                                    Double aBar = selectedPeriod.getBarometerSD();
                                    GUI.segmentNumber(aBar, 0, "0000.0");
                                    IO.delay(500);
                                }
                            } else if (selected.getName().equalsIgnoreCase("gemiddeld")){
                                if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                    GUI.clearSegment();
                                    Double aHum = selectedPeriod.getAverageOutsideHumidity();
                                    GUI.segmentNumber(aHum, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                    GUI.clearSegment();
                                    Double aTemp = selectedPeriod.getAverageOutsideTemp();
                                    GUI.segmentNumber(aTemp, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                    GUI.clearSegment();
                                    Double aBar = selectedPeriod.getAverageBarometer();
                                    GUI.segmentNumber(aBar, 0, "0000.0");
                                    IO.delay(500);
                                }
                            } else if (selected.getName().equalsIgnoreCase("minimaal")){
                                if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                    GUI.clearSegment();
                                    int aHum = selectedPeriod.getLowestOutsideHumidity();
                                    GUI.segmentNumber(aHum, 0, "00");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                    GUI.clearSegment();
                                    Double aTemp = selectedPeriod.getLowestOutsideTemp();
                                    GUI.segmentNumber(aTemp, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                    GUI.clearSegment();
                                    Double aBar = selectedPeriod.getLowestBarometer();
                                    GUI.segmentNumber(aBar, 0, "00.0");
                                    IO.delay(500);
                                }
                            } else if (selected.getName().equalsIgnoreCase("maximaal")){
                                if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                    GUI.clearSegment();
                                    int aHum = selectedPeriod.getHighestOutsideHumidity();
                                    GUI.segmentNumber(aHum, 0, "00");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                    GUI.clearSegment();
                                    Double aTemp = selectedPeriod.getHighestOutsideTemp();
                                    GUI.segmentNumber(aTemp, 0, "00.0");
                                    IO.delay(500);
                                } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                    GUI.clearSegment();
                                    Double aBar = selectedPeriod.getHighestBarometer();
                                    GUI.segmentNumber(aBar, 0, "00.0");
                                    IO.delay(500);
                                }
                            }
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
                            Period period = new Period(7);
                            periodSelected = true;
                            selectedPeriod = period;
                        } else if (selected.getName().equalsIgnoreCase("last hour")){
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
                    } else if (selected.getName().equalsIgnoreCase("assignment daan")){
                        if (periodSelected){
                            GUI.clearSegment();
                            double difference = selectedPeriod.getDiffWindChillAndOutsideTemp();
                            LocalDate date = selectedPeriod.getDateBiggestDiff();
                            String sDate = String.valueOf(date);
                            int pos1 = sDate.indexOf('-');
                            int pos2 = sDate.lastIndexOf('-');
                            GUI.segmentNumber(difference, 0, "00.0");
                            GUI.segmentNumber(Double.parseDouble(sDate.substring(pos1+1, pos2)), 2, "00");
                            GUI.segmentNumber(Double.parseDouble(sDate.substring(pos2+1)), 1, "00");
                            IO.delay(500);
                        }
                    } else if (selected.getName().equalsIgnoreCase("assignment storm")){
                        if (periodSelected){
                            GUI.clearSegment();
                            //code...
                            IO.delay(500);
                        }
                    } else if (selected.getName().equalsIgnoreCase("assignment melvin")){
                        if (periodSelected){
                            GUI.clearSegment();
                            //code...
                            IO.delay(500);
                        }
                    } else if (selected.getName().equalsIgnoreCase("assignment tiemen")){
                        if (periodSelected){
                            GUI.clearSegment();
                            //code...
                            IO.delay(500);
                        }
                    } else if (selected.getName().equalsIgnoreCase("assignment erik")){
                        if (periodSelected){
                            GUI.clearSegment();
                            //code...
                            IO.delay(500);
                        }
                    } else if (selected.getName().equalsIgnoreCase("assignment lucas")){
                        if (periodSelected){
                            GUI.clearSegment();

                            boolean Heatwave = selectedPeriod.Heatwave();
                            if (Heatwave) { GUI.segmentNumber(1, 0, "0");
                            } else { GUI.segmentNumber(0, 0, "0"); }

                            IO.delay(500);
                        }
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