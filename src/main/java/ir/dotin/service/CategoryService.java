package ir.dotin.service;

import ir.dotin.entity.SubCategory;
import ir.dotin.repository.CategoryDA;
import ir.dotin.entity.Category;
import ir.dotin.to.SubCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    CategoryDA categoryDA;

    public Category loadCategoryById2(Long categoryId) {
        Category categoryById = categoryDA.findCategoryById(categoryId);
        return categoryById;
    }
    public List<SubCategoryDTO> loadSubCategoriesByName(String categoryName) {
        List<SubCategoryDTO> subCategoryList = categoryDA.findSubCategoriesByName(categoryName);
        return subCategoryList;
    }

    public SubCategoryDTO loadSubCategoryBySubCategoryName(String subCategoryName) {
        SubCategoryDTO subCategoryByName = categoryDA.findSubCategoryByName(subCategoryName);
        return subCategoryByName;
    }
}
