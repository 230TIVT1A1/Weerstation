import java.util.ArrayList;

public class Menu {
    private String name = "";
    private int rows = 2;
    private int itemsPerRow = 4;
    private ArrayList<MenuItem> items = new ArrayList<>();
    private MenuItem currentItem = null;

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, int rows) {
        this.name = name;
        this.rows = rows;
    }

    public Menu(String name, int rows, int itemsPerRow) {
        this.name = name;
        this.rows = rows;
        this.itemsPerRow = itemsPerRow;
    }

    public Menu(ArrayList<MenuItem> items) {
        this.items = items;
        this.currentItem = items.get(0);
    }

    //inBetweenRows is amount of pixels between rows
    public void displayIcons(int px, int py, int inBetweenRows) {
        ArrayList<String> icons = new ArrayList<>();
        int row = 0;
        for (MenuItem item : this.items) {
            if (item.hasIcon()) {
                if (item == this.currentItem) {
                    icons.add(item.getIcon() + "-selected.png");
                } else {
                    icons.add(item.getIcon() + ".png");
                }
                if (icons.size() >= this.itemsPerRow) {
                    IconDisplay.drawArray(icons, px, py + row * inBetweenRows);
                    row++;
                    icons.clear();
                }
            }
        }


    }

    public void addItem(MenuItem item) {
        this.items.add(item);
        if (this.currentItem == null) {
            this.currentItem = item;
        }
    }

    public void removeItem(String name) {
        this.items.removeIf(item -> item.getName().equals(name));
    }

    public MenuItem getItemString(String name) {
        for (MenuItem item : this.items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public MenuItem getItem(int index) {
        return this.items.get(index);
    }

    public ArrayList<MenuItem> getItems() {
        return this.items;
    }

    public void setCurrentItem(String name) {
        for (MenuItem item : this.items) {
            if (item.getName().equalsIgnoreCase(name)) {
                this.currentItem = item;
            }
        }
    }

    public MenuItem getCurrentItem() {
        return this.currentItem;
    }

    public int getIndexOfCurrentItem() {
        return this.items.indexOf(this.currentItem);
    }

    public String getName() {
        return this.name;
    }

    public void nextItem() {
        int index = this.items.indexOf(this.currentItem) + 1;
        if (index < this.items.size()) {
            this.currentItem = this.items.get(index);
        } else {
            this.currentItem = this.items.get(0);
        }
    }

    public void previousItem() {
        int index = this.items.indexOf(this.currentItem) - 1;
        if (index >= 0) {
            this.currentItem = this.items.get(index);
        } else {
            this.currentItem = this.items.get(items.size() - 1);
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + this.name + '\'' +
                ", items=" + this.items +
                ", currentItem=" + this.currentItem +
                '}' + "\n";
    }
}
