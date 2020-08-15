package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_subcategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory extends ParentEntity {

    @Column(name = "c_subCategoryName")
    private String subCategoryName;
    @Column(name = "c_subCategoryFarsiName")
    private String subCategoryFarsiName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_main_category_id")
    private Category mainCategory;

}
