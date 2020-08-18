package ir.dotin.to;

import ir.dotin.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO extends ParentEntityDTO implements Serializable {

    private String subCategoryName;
    private String subCategoryFarsiName;


    private CategoryDTO mainCategory;

    public SubCategoryDTO(SubCategory subCategory) {
        super(subCategory);
        this.subCategoryName = subCategory.getSubCategoryName();
        this.subCategoryFarsiName = subCategory.getSubCategoryFarsiName();
        if (subCategory.getMainCategory() != null) {
            this.mainCategory = new CategoryDTO(subCategory.getMainCategory());
        }
    }

}