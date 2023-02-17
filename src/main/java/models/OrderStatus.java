package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_order_statuses")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected boolean isDelete;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    @Column(length = 255, nullable = false)
    private String name;


    @OneToMany(mappedBy = "orderStatus")
    private List<Order> orders;

    public OrderStatus() {
        orders = new ArrayList<>();
    }

    public OrderStatus(boolean isDelete, Date dateCreated, String name) {
        super();
        this.isDelete = isDelete;
        this.dateCreated = dateCreated;
        this.name = name;
    }
}
