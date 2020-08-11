package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_subCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory extends Common {

    @Column(name = "c_subCategoryName")
    private String subCategoryName;
    @Column(name = "c_subCategoryFarsiName")
    private String subCategoryFarsiName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category mainCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfRequest", fetch = FetchType.LAZY)
    private List<OffRequest> offRequestList;
}
