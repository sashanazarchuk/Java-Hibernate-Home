package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filters")
@IdClass(FilterPK.class)
public class Filter {
    @Id
    @ManyToOne
    @JoinColumn(name = "filterName_id", nullable = false)
    private FilterName filterName;
    @Id
    @ManyToOne
    @JoinColumn(name = "filterValue_id", nullable = false)
    private FilterValue filterValue;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
