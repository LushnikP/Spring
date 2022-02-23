package lesson4;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private int id;

    @Column(name="title")
    private String title;


    @OneToMany(mappedBy = "category_id")
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String allProducts = "";
        for (Product p : products){
            allProducts += p.getTitle() + " ";
        }
        return "Category [" + id + " " + title + " " + allProducts + "]";
    }
}
