import java.util.ArrayList;

public class Menus {
    private ArrayList<Menu> menus = new ArrayList<>();
    private Menu currentMenu;

    public Menus(ArrayList<Menu> menus) {
        this.menus = menus;
        this.currentMenu = menus.get(0);
    }

    public ArrayList<Menu> getMenus() {
        return this.menus;
    }
    public void addMenu(Menu menu){
        this.menus.add(menu);
        if(this.currentMenu == null){
            this.currentMenu = menu;
        }
    }
    public void removeMenu(String name){
        this.menus.removeIf(menu -> menu.getName().equals(name));
    }
    public ArrayList<Menu> getItems(){
        return this.menus;
    }
    public void setCurrentMenu(String name){
        for (Menu menu:this.menus) {
            if(menu.getName().equalsIgnoreCase(name)) {
                this.currentMenu = menu;
            }
        }
    }
    public Menu getCurrentMenu(){
        return this.currentMenu;
    }
    public Menu getMenu(int index){
        return this.menus.get(index);
    }

    public int getIndexOfCurrentMenu(){
        return this.menus.indexOf(this.currentMenu);
    }
    public void nextMenu(){
        int index = getIndexOfCurrentMenu()+1;
        if(index < this.menus.size()) {
            this.currentMenu = this.menus.get(index);
        } else {
            this.currentMenu = this.menus.get(0);
        }
    }
    public void previousMenu(){
        int index = getIndexOfCurrentMenu()-1;
        if(index >= 0) {
            this.currentMenu = this.menus.get(index);
        } else {
            this.currentMenu = this.menus.get(menus.size()-1);
        }
    }
}
