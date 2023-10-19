import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> items = new ArrayList<>();
    private MenuItem currentItem = null;

    public Menu(){
    }
    public Menu(ArrayList<MenuItem> items){
        this.items = items;
        this.currentItem = items.get(0);
    }
    // TODO: 19/10/2023 add icon method to display menu items
    public void displayIcons(){
        for (MenuItem item:this.items) {
            if(item.hasIcon()) {
//                here we print all icons
                if (item == this.currentItem) {
//                draw the active icon instead of normal icon
                }
            }
        }
    }
    public void addItem(MenuItem item){
        this.items.add(item);
        if(currentItem == null){
            currentItem = item;
        }
    }
    public void removeItem(String item){
        this.items.remove(item);
    }
    public ArrayList<MenuItem> getItems(){
        return this.items;
    }
    public void setCurrentItem(String name){
        for (MenuItem item:items) {
            if(item.getName() == name) {
                this.currentItem = item;
            }
        }
    }
    public MenuItem getCurrentItem(){
        return this.currentItem;
    }
    public void nextItem(){
        int index = this.items.indexOf(this.currentItem)+1;
        if(index < items.size()) {
            currentItem = items.get(index);
        }
    }
    public void previousItem(){
        int index = this.items.indexOf(this.currentItem)-1;
        if(index >= 0) {
            currentItem = items.get(index);
        }
    }

}
