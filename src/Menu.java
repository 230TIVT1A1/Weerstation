import java.util.ArrayList;

public class Menu {
    private String name = "";
    private ArrayList<MenuItem> items = new ArrayList<>();
    private MenuItem currentItem = null;
    public Menu(String name){
        this.name = name;
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
        if(this.currentItem == null){
            this.currentItem = item;
        }
    }
    public void removeItem(String name){
        this.items.removeIf(item -> item.getName().equals(name));
    }
    public ArrayList<MenuItem> getItems(){
        return this.items;
    }
    public void setCurrentItem(String name){
        for (MenuItem item:items) {
            if(item.getName().equalsIgnoreCase(name)) {
                this.currentItem = item;
            }
        }
    }
    public MenuItem getCurrentItem(){
        return this.currentItem;
    }
    public int getIndexOfCurrentItem(){
        return this.items.indexOf(this.currentItem);
    }
    public String getName(){
        return this.name;
    }
    public void nextItem(){
        int index = this.items.indexOf(this.currentItem)+1;
        if(index < this.items.size()) {
            this.currentItem = this.items.get(index);
        }
    }
    public void previousItem(){
        int index = this.items.indexOf(this.currentItem)-1;
        if(index >= 0) {
            this.currentItem = this.items.get(index);
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + this.name + '\'' +
                ", items=" + this.items +
                ", currentItem=" + this.currentItem +
                '}'+"\n";
    }
}
