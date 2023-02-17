package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//аналогічно до класу Product
@Data
@Entity
@Table(name = "tbl_product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500, nullable = false)
    private String name;
    private int priority;
    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    public ProductImage(Date dateCreated, boolean isDelete, String name, int priority, Product product) {
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.name = name;
        this.priority = priority;
        this.product = product;
    }
}
