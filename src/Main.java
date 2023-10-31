import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static boolean run = true;
    public static Period selectedPeriod = new Period(7);
    public static MenuItem mainMenuSelected = new MenuItem();

    public static void main(String[] args) {
        IO.init();
        GUI.clearSegment();
        GUI.clrDisplay();


        // Declare menus
        Menu mainMenu = new Menu("mainMenu",2,7);
        mainMenu.addItem(new MenuItem("hum","icons/humidity"));
        mainMenu.addItem(new MenuItem("temp","icons/temp"));
        mainMenu.addItem(new MenuItem("uv","icons/uv"));
        mainMenu.addItem(new MenuItem("rain","icons/rainrate"));
        mainMenu.addItem(new MenuItem("wind","icons/wind"));
        mainMenu.addItem(new MenuItem("sunrise","icons/sunrise"));
        mainMenu.addItem(new MenuItem("extra","icons/Extra"));

        mainMenu.addItem(new MenuItem("heat","icons/heatindex"));
        mainMenu.addItem(new MenuItem("solar","icons/Solarrad"));
        mainMenu.addItem(new MenuItem("dew","icons/dewpoint"));
        mainMenu.addItem(new MenuItem("bar","icons/barometer"));
        mainMenu.addItem(new MenuItem("chill","icons/windchill"));
        mainMenu.addItem(new MenuItem("sunset","icons/sunset"));
        mainMenu.addItem(new MenuItem("exit","icons/quit"));

        Menu location = new Menu("location", 1,3);
        location.addItem(new MenuItem("back","icons/back"));
        location.addItem(new MenuItem("outside", "icons/outside"));
        location.addItem(new MenuItem("inside", "icons/inside"));

        Menu extraMenu = new Menu("extraMenu", 1, 3);
        extraMenu.addItem(new MenuItem("back","icons/back"));
        extraMenu.addItem(new MenuItem("period", "icons/period"));
        extraMenu.addItem(new MenuItem("assignments", "icons/assignments"));

        Menu subMenu = new Menu("subMenu", 1, 7);
        subMenu.addItem(new MenuItem("back","icons/back"));
        subMenu.addItem(new MenuItem("mode","icons/mode"));
        subMenu.addItem(new MenuItem("median","icons/median"));
        subMenu.addItem(new MenuItem("standardDeviation","icons/standardDeviation"));
        subMenu.addItem(new MenuItem("average","icons/average"));
        subMenu.addItem(new MenuItem("minimum","icons/minimum"));
        subMenu.addItem(new MenuItem("maximum","icons/maximum"));

        Menu periodMenu = new Menu("periodMenu", 1, 7);
        periodMenu.addItem(new MenuItem("back","icons/back"));
        periodMenu.addItem(new MenuItem("Last year","icons/lastyear"));
        periodMenu.addItem(new MenuItem("Last month","icons/lastmonth"));
        periodMenu.addItem(new MenuItem("Last week","icons/lastweek"));
        periodMenu.addItem(new MenuItem("This day","icons/thisday"));
        periodMenu.addItem(new MenuItem("Yesterday","icons/yesterday"));
        periodMenu.addItem(new MenuItem("Last Hour","icons/Clearer - Copy (2)"));

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
        menuArray.add(location);
        menuArray.add(extraMenu);
        menuArray.add(periodMenu);
        menuArray.add(assignmentsMenu);

        Menus menus = new Menus(menuArray);

        // Program code
        while (run) {
            // Read buttons states
            Button.updateButtons();
            // Get current menu and item
            Menu selectedMenu = menus.getCurrentMenu();
            MenuItem selected = menus.getCurrentMenu().getCurrentItem();

            // Buttons
            if (Button.previousButtonChanged()){
                // Previous item
                menus.getCurrentMenu().previousItem();
            } else if (Button.nextButtonChanged()){
                // Next item
                menus.getCurrentMenu().nextItem();
            } else if (Button.selectButtonChanged()){
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
                        
                    }else if (selected.getName().equalsIgnoreCase("temp")){
                        // Location
                        GUI.clrDisplay();
                        menus.setCurrentMenu("location");
                        
                    }else if (selected.getName().equalsIgnoreCase("hum")){
                        // Location
                        GUI.clrDisplay();
                        menus.setCurrentMenu("location");
                        
                    } else if (selected.getName().equalsIgnoreCase("wind")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displayWindGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("dew")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displayDewpointGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("heat")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displayHeatindexGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("rain")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displayRainrateGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("solar")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displaySolarradiationGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("sunrise")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displaySunriseGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("sunset")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displaySunsetGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("uv")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displayUVIndexGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("chill")){
                        GUI.clrDisplay();
                        boolean graph = true;
                        DisplayGraph.displayWindchillGraph(selectedPeriod);
                        while (graph) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                graph = false;
                                GUI.clrDisplay();
                            }
                        }
                    } else {
                        // subMenu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("subMenu");
                        
                    }
                }else if (selectedMenu.getName().equalsIgnoreCase("location")) {
                    if (selected.getName().equalsIgnoreCase("back")) {
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("mainMenu");

                    } else if (selected.getName().equalsIgnoreCase("outside")) {
                        GUI.clrDisplay();
                        if (mainMenuSelected.getName().equalsIgnoreCase("temp")) {
                            GUI.clrDisplay();
                            boolean graph = true;
                            DisplayGraph.displayOutsideTempGraph(selectedPeriod);
                            while (graph) {
                                Button.updateButtons();
                                if (Button.anyButtonChanged()) {
                                    graph = false;
                                    GUI.clrDisplay();
                                }
                            }
                        } else if (mainMenuSelected.getName().equalsIgnoreCase("hum")) {
                            GUI.clrDisplay();
                            boolean graph = true;
                            DisplayGraph.displayOutsideHumidityGraph(selectedPeriod);
                            while (graph) {
                                Button.updateButtons();
                                if (Button.anyButtonChanged()) {
                                    graph = false;
                                    GUI.clrDisplay();
                                }
                            }
                        }
                    } else if (selected.getName().equalsIgnoreCase("inside")) {
                        GUI.clrDisplay();
                        if (mainMenuSelected.getName().equalsIgnoreCase("temp")) {
                            System.out.println("inside temp");
                            GUI.clrDisplay();
                            boolean graph = true;
                            DisplayGraph.displayInsideTempGraph(selectedPeriod);
                            while (graph) {
                                Button.updateButtons();
                                if (Button.anyButtonChanged()) {
                                    graph = false;
                                    GUI.clrDisplay();
                                }
                            }
                        } else if (mainMenuSelected.getName().equalsIgnoreCase("hum")) {
                            GUI.clrDisplay();
                            boolean graph = true;
                            DisplayGraph.displayInsideHumidityGraph(selectedPeriod);
                            while (graph) {
                                Button.updateButtons();
                                if (Button.anyButtonChanged()) {
                                    graph = false;
                                    GUI.clrDisplay();
                                }
                            }
                        }
                    }
                }
                // Sub menu
                else if (selectedMenu.getName().equalsIgnoreCase("subMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("mainMenu");
                        
                    } else{
                        // Statistic selected
                        if (selected.getName().equalsIgnoreCase("mode")){
                            if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                GUI.clearSegment();
                                Double aHum = selectedPeriod.getOutsideHumidityMode();
                                GUI.segmentNumber(aHum, 0, "0.0");
                                
                            } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                GUI.clearSegment();
                                Double aTemp = selectedPeriod.getOutsideTempMode();
                                GUI.segmentNumber(aTemp, 0, "0.0");
                                
                            } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                GUI.clearSegment();
                                Double aBar = selectedPeriod.getBarometerMode();
                                GUI.segmentNumber(aBar, 0, "0.0");
                                
                            }
                        } else if (selected.getName().equalsIgnoreCase("median")){
                            if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                GUI.clearSegment();
                                int aHum = selectedPeriod.getOutsideHumidityMedian();
                                GUI.segmentNumber(aHum, 0, "0");
                                
                            } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                GUI.clearSegment();
                                Double aTemp = selectedPeriod.getOutsideTempMedian();
                                GUI.segmentNumber(aTemp, 0, "0.0");
                                
                            } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                GUI.clearSegment();
                                Double aBar = selectedPeriod.getBarometerMedian();
                                GUI.segmentNumber(aBar, 0, "0.0");
                                
                            }
                        } else if (selected.getName().equalsIgnoreCase("standardDeviation")){
                            if (mainMenuSelected.getName().equalsIgnoreCase("hum")){
                                GUI.clearSegment();
                                Double aHum = selectedPeriod.getOutsideHumiditySD();
                                GUI.segmentNumber(aHum, 0, "0.0");
                                
                            } else if (mainMenuSelected.getName().equalsIgnoreCase("temp")){
                                GUI.clearSegment();
                                Double aTemp = selectedPeriod.getOutsideTempSD();
                                GUI.segmentNumber(aTemp, 0, "0.0");
                                
                            } else if (mainMenuSelected.getName().equalsIgnoreCase("bar")){
                                GUI.clearSegment();
                                Double aBar = selectedPeriod.getBarometerSD();
                                GUI.segmentNumber(aBar, 0, "0.0");
                                
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
                        
                    } else if (selected.getName().equalsIgnoreCase("period")){
                        // Period menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("periodMenu");
                        
                    } else if (selected.getName().equalsIgnoreCase("assignments")){
                        // Assignments menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("assignmentsMenu");

                    }
                }
                // Period menu
                else if (selectedMenu.getName().equalsIgnoreCase("periodMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        
                    } else {
                        // TODO: 31/10/2023 Period selected (Nog te veranderen!)
                        if (selected.getName().equalsIgnoreCase("last year")){
                            selectedPeriod = new Period(365);
                        } else if (selected.getName().equalsIgnoreCase("last month")){
                            selectedPeriod = new Period(30);
                        } else if (selected.getName().equalsIgnoreCase("last week")){
                            selectedPeriod = new Period(7);
                        } else if (selected.getName().equalsIgnoreCase("last hour")){
                            selectedPeriod = new Period(0);
                        } else if (selected.getName().equalsIgnoreCase("today")){
                            selectedPeriod = new Period(0);
                        } else if (selected.getName().equalsIgnoreCase("yesterday")){
                            selectedPeriod = new Period(1);
                        }
                    }
                }
                // Assignments menu
                else if (selectedMenu.getName().equalsIgnoreCase("assignmentsMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        
                    } else if (selected.getName().equalsIgnoreCase("assignment daan")){
                        GUI.clearSegment();
                        double difference = selectedPeriod.getDiffWindChillAndOutsideTemp();
                        LocalDate date = selectedPeriod.getDateBiggestDiff();
                        String sDate = String.valueOf(date);
                        int pos1 = sDate.indexOf('-');
                        int pos2 = sDate.lastIndexOf('-');
                        GUI.segmentNumber(difference, 0, "0.0");
                        GUI.segmentNumber(Double.parseDouble(sDate.substring(pos1+1, pos2)), 2, "00");
                        GUI.segmentNumber(Double.parseDouble(sDate.substring(pos2+1)), 1, "00");
                        
                    } else if (selected.getName().equalsIgnoreCase("assignment storm")){
                        GUI.clearSegment();
                        //code...
                        
                    } else if (selected.getName().equalsIgnoreCase("assignment melvin")){
                        GUI.clearSegment();
                        GUI.segmentNumber(selectedPeriod.maxTemperatureDifference(), 0, "0.0");
                        GUI.segmentNumber(selectedPeriod.getLowestOutsideTemp(), 1, "0.0");
                        GUI.segmentNumber(selectedPeriod.getHighestOutsideTemp(), 2, "0.0");
                        
                    } else if (selected.getName().equalsIgnoreCase("assignment tiemen")){
                        GUI.clrDisplay();
                        boolean showText = true;
                        Period longestDrougth = selectedPeriod.longestDrougth();
                        GUI.showText("langste droogte");
                        GUI.showText("\n" + longestDrougth.getRawMeasurements().get(0).getDateStamp().toLocalDate().toString());
                        GUI.showText("\n" + longestDrougth.getRawMeasurements().get(longestDrougth.getRawMeasurements().size()-1).getDateStamp().toLocalDate().toString());
                        while (showText) {
                            Button.updateButtons();
                            if (Button.anyButtonChanged()) {
                                showText = false;
                                GUI.clrDisplay();
                            }
                        }
                        
                    } else if (selected.getName().equalsIgnoreCase("assignment Erik")){
                        GUI.clearSegment();
                        ArrayList<LocalDate> returnDays = selectedPeriod.getGoodDays();
                        int days = 0;
                        for (int i = 1; i <= returnDays.size(); i++){
                            days++;
                        }
                        GUI.segmentNumber(days, 0, "0");
                        
                    } else if (selected.getName().equalsIgnoreCase("assignment lucas")){
                        GUI.clearSegment();
                        boolean Heatwave = selectedPeriod.Heatwave();
                        if (Heatwave) {
                            GUI.segmentNumber(1, 0, "0");
                        } else {
                            GUI.segmentNumber(0, 0, "0");
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