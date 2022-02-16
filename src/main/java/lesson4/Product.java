package lesson4;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long product_id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    public Long getProduct_id() {
        return product_id;
    }

    public void setId(long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product |" + product_id + " " + title + " " + price + " " + category_id.getTitle() +"|";
    }
}
