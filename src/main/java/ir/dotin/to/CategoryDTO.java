package ir.dotin.to;

import ir.dotin.entity.Category;
import ir.dotin.entity.ParentEntity;
import ir.dotin.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO extends ParentEntityDTO implements Serializable {
    private String categoryName;
    private List<SubCategoryDTO> subCategories;

    public CategoryDTO(Category category) {
        super(category);
        this.categoryName = category.getCategoryName();
        if (subCategories != null && subCategories.size() != 0) {
            List<SubCategoryDTO> subCategoryDTOS = new ArrayList<>();
            for (SubCategory subCategory : category.getSubCategories()) {
                SubCategoryDTO subCategoryDTO = new SubCategoryDTO(subCategory);
                subCategoryDTOS.add(subCategoryDTO);
            }
            this.subCategories = subCategoryDTOS;
        }
    }

}
