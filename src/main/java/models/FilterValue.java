package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_filter_values")
public class FilterValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected boolean isDelete;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    @Column(length = 255, nullable = false)
    private String name;
    @OneToMany(mappedBy = "filterValue")
    private List<FilterNameGroup> filterNameGroups;
    @OneToMany(mappedBy = "filterName")
    private List<Filter> filters;

    public FilterValue() {
        filterNameGroups = new ArrayList<>();
        filters = new ArrayList<>();
    }
}
