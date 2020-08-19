package ir.dotin.entity;

import ir.dotin.to.CategoryDTO;
import ir.dotin.to.SubCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends ParentEntity {
    @Column(name = "c_categoryname")
    private String categoryName;

    @JoinColumn(name = "c_maincategoryid")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubCategory> subCategories;

    public Category(CategoryDTO categoryDTO) {
        super(categoryDTO);
        this.categoryName = categoryDTO.getCategoryName();
        List<SubCategory> subCategories = new ArrayList<>();
        if (categoryDTO.getSubCategories()!=null){
            for (SubCategoryDTO subCategoryDTO : categoryDTO.getSubCategories()) {
                SubCategory subCategory = new SubCategory(subCategoryDTO);
                subCategories.add(subCategory);
            }
            this.subCategories = subCategories;
        }

    }


}
