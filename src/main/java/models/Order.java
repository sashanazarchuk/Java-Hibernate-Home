package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDelete;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    @ManyToOne
    @JoinColumn(name = "orderStatus_id", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    public Order() {
        orderItems = new ArrayList<>();
    }
    public Order(boolean isDelete, Date dateCreated, OrderStatus orderStatus, User user) {
        super();
        this.isDelete = isDelete;
        this.dateCreated = dateCreated;
        this.orderStatus = orderStatus;
        this.user = user;
    }
}
