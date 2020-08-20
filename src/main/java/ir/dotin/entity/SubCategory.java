package ir.dotin.entity;

import ir.dotin.to.SubCategoryDTO;
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

    @Column(name = "c_subcategoryname")
    private String subCategoryName;
    @Column(name = "c_subcategoryfarsiname")
    private String subCategoryFarsiName;

}
