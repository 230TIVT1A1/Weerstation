public class MenuLoop {
    public boolean run = true;

    public MenuItem mainMenuSelected = new MenuItem();

    private final Menus menus;

    public MenuLoop(Menus menuArray) {
        menus = menuArray;

        startLoop();
    }

    public void startLoop() {
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
                        if (PeriodSelect.isSelected){
                            new SetSegDisplay(mainMenuSelected, selected, PeriodSelect.selectedPeriod);
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
                        new PeriodSelect(selected.getName());
                    }
                }
                // Assignments menu
                else if (selectedMenu.getName().equalsIgnoreCase("assignmentsMenu")){
                    if (selected.getName().equalsIgnoreCase("back")){
                        // Main menu
                        GUI.clrDisplay();
                        menus.setCurrentMenu("extraMenu");
                        IO.delay(500);
                    } else if (PeriodSelect.isSelected){
                        new SetSegDisplay(selected, PeriodSelect.selectedPeriod);
                    }

                }
            }
            // Show icons
            menus.getCurrentMenu().displayIcons(3, 3, 15);
        }
    }
}
