package ir.dotin.service;

import ir.dotin.repository.CategoryDA;
import ir.dotin.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
    @Autowired
    CategoryDA categoryDA;

    public Category loadCategoryById(Long categoryId) {
        Category categoryById = categoryDA.findCategoryById(categoryId);
        return categoryById;
    }
}
