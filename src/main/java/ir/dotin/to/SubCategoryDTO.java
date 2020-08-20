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
}