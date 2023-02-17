package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data//дозволяє застосувати getter i setter
@Entity//представляє таблицю в бд
@Table(name = "tbl_products")// назва таблиці для бд
public class Product {
    @Id// первинний ключ(Primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// авто інкремент по ключу, коли додається новий запис
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)//зберігаю доту і час
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500, nullable = false)// колонка для name довжина 500 і не може бути нуль
    private String name;
    @Column(length = 4000)// колонка для опису довжина 4000
    private String description;
    @ManyToOne//зв'язок баато до одного
    @JoinColumn(name="category_id", nullable = false) //приєднання колонок
    private Category category;
    @OneToMany(mappedBy = "product")//зв'язок один до багатьох
    private List<ProductImage> productImages;//список фото продуктів
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
    @OneToMany(mappedBy = "product")
    private List<Filter> filters;
    @OneToMany(mappedBy = "product")
    private List<Baskets> baskets;
    public Product(){
    productImages = new ArrayList<>();
    orderItems = new ArrayList<>();
    filters = new ArrayList<>();
    baskets = new ArrayList<>();
    }

    public Product(Date dateCreated, boolean isDelete, String name, String description, Category category) {
        super();//виклик конструктора за замовчуванням
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
