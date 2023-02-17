package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data//дозволяє застосувати getter i setter
@Entity//представляє таблицю в бд
@Table(name="tbl_categories")// назва таблиці для бд
public class Category {
    @Id// первинний ключ(Primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// авто інкремент по ключу, коли додається новий запис
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)//зберігаю доту і час
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500, nullable = false)// колонка для name довжина 500 і не може бути нуль
    private String name;
    @Column(length = 200)
    private String image;// колонка для image довжина 200 і не може бути нуль

    @OneToMany(mappedBy = "category")//зв'язок один до багатьох
    private List<Product> products;

    public Category() {
        products=new ArrayList<>();
    }

    public Category(String name, String image, Date dateCreate, boolean isDelete) {
        super();//виклик конструктора за замовчуванням
        this.name = name;
        this.image = image;
        this.dateCreated=dateCreate;
        this.isDelete=isDelete;
    }
}
