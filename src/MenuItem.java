public class MenuItem {
    private String name = "";
    private String icon = "";

    public MenuItem() {
    }
    public MenuItem(String name) {
        this.name = name;
    }
    public MenuItem(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }
    public boolean hasIcon(){
        return !this.icon.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return this.icon;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + this.name + "'" +
                ", icon='" + this.icon + "'" +
                '}';
    }
}
