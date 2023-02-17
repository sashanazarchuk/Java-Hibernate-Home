package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDelete;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    private int priceBuy;
    private int count;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public OrderItem(boolean isDelete, Date dateCreated, int priceBuy, int count, Order order, Product product) {
        this.isDelete = isDelete;
        this.dateCreated = dateCreated;
        this.priceBuy = priceBuy;
        this.count = count;
        this.order = order;
        this.product = product;
    }
}
