package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filter_name_groups")
@IdClass(FilterNameGroupPK.class)
public class FilterNameGroup {
    @Id
    @ManyToOne
    @JoinColumn(name = "filterName_id", nullable = false)
    private FilterName filterName;
    @Id
    @ManyToOne
    @JoinColumn(name = "filterValue_id", nullable = false)
    private FilterValue filterValue;
}
