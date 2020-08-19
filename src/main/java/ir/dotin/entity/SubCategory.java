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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_maincategoryid")
    private Category mainCategory;

    public SubCategory(SubCategoryDTO subCategoryDTO) {
        super(subCategoryDTO);
        this.subCategoryName = subCategoryDTO.getSubCategoryName();
        if (subCategoryDTO.getSubCategoryFarsiName() != null) {
            this.subCategoryFarsiName = subCategoryDTO.getSubCategoryFarsiName();
            ;
        }
        if (subCategoryDTO.getMainCategory() != null) {
            this.mainCategory = new Category(subCategoryDTO.getMainCategory());
        }
    }

}
