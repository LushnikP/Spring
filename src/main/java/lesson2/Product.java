package lesson2;

public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(int id, String title) {
        this.id = id;
        this.title = title;
        this.cost = (10 * id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + title + ", "  + "cost: " + cost + "; ";
    }
}
