package ir.dotin.service;

import ir.dotin.entity.SubCategory;
import ir.dotin.repository.CategoryDA;
import ir.dotin.to.SubCategoryDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {
    @Autowired
    CategoryDA categoryDA;
    @Autowired
    private ModelMapper modelMapper;

    public List<SubCategoryDTO> loadSubCategoriesByName(String categoryName) {
        List<SubCategory> subCategoriesByCategoryName = categoryDA.findSubCategoriesByCategoryName(categoryName);

        List<SubCategoryDTO> subCategoryDTOs = modelMapper.map(subCategoriesByCategoryName, new TypeToken<List<SubCategoryDTO>>() {}.getType());
        return subCategoryDTOs;
    }

    public SubCategoryDTO loadSubCategoryBySubCategoryName(String subCategoryName) {
        SubCategory subCategoryByName = categoryDA.findSubCategoryByName(subCategoryName);
        SubCategoryDTO subCategoryDTO = modelMapper.map(subCategoryByName, SubCategoryDTO.class);
        return subCategoryDTO;
    }
}
