package ir.dotin.initialize;

import ir.dotin.entity.Category;
import ir.dotin.entity.SubCategory;
import ir.dotin.repository.CategoryDA;
import ir.dotin.to.SubCategoryDTO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class CategoryInitializer implements InitializingBean {
    private static CategoryInitializer instance;

    @Autowired
    private CategoryDA categoryDA;

    public static CategoryInitializer get() {
        return instance;
    }

    @Override
    public void afterPropertiesSet() {
        instance = this;
    }


    public void addPersonRoleCategory() {

        List<SubCategoryDTO> roles = categoryDA.findSubCategoriesByCategoryName("role");
        if (roles == null) {
            Category category = new Category();
            category.setCategoryName("role");
            category.setActive(true);
            category.setCreationDate(new Date().toString());
            List<SubCategory> subCategories = new ArrayList<>();

            SubCategory subCategory1 = new SubCategory();
            subCategory1.setSubCategoryFarsiName("کارمند");
            subCategory1.setSubCategoryName("employee");
            subCategory1.setCreationDate(new Date().toString());
            subCategory1.setActive(true);
            subCategory1.setMainCategory(category);

            SubCategory subCategory2 = new SubCategory();
            subCategory2.setSubCategoryFarsiName("مدیر");
            subCategory2.setSubCategoryName("manager");
            subCategory2.setCreationDate(new Date().toString());
            subCategory2.setActive(true);
            subCategory2.setMainCategory(category);

            subCategories.addAll(Arrays.asList(subCategory1, subCategory2));
            category.setSubCategories(subCategories);

            categoryDA.addCategory(category);
        }
    }

    public void addTypeOfRequestCategory() {
        List<SubCategoryDTO> typeOfRequest = categoryDA.findSubCategoriesByCategoryName("typeOfRequest");
        if (typeOfRequest == null) {
            Category category = new Category();
            category.setCategoryName("typeOfRequest");
            category.setActive(true);
            category.setCreationDate(new Date().toString());

            SubCategory subCategory1 = new SubCategory();
            subCategory1.setSubCategoryFarsiName("روزانه");
            subCategory1.setSubCategoryName("daily");
            subCategory1.setCreationDate(new Date().toString());
            subCategory1.setActive(true);
            subCategory1.setMainCategory(category);

            SubCategory subCategory2 = new SubCategory();
            subCategory2.setSubCategoryFarsiName("ساعتی");
            subCategory2.setSubCategoryName("hourly");
            subCategory2.setCreationDate(new Date().toString());
            subCategory2.setActive(true);
            subCategory2.setMainCategory(category);

            List<SubCategory> subCategories = new ArrayList<>();
            subCategories.addAll(Arrays.asList(subCategory1, subCategory2));
            category.setSubCategories(subCategories);
            categoryDA.addCategory(category);
        }
    }

    public void addStatusOfRequest() {
        List<SubCategoryDTO> statusOfRequest = categoryDA.findSubCategoriesByCategoryName("statusOfRequest");
        if (statusOfRequest == null) {

            Category category = new Category();
            category.setCategoryName("statusOfRequest");
            category.setActive(true);
            category.setCreationDate(new Date().toString());

            SubCategory subCategory1 = new SubCategory();
            subCategory1.setSubCategoryFarsiName("تایید شده");
            subCategory1.setSubCategoryName("confirmed");
            subCategory1.setActive(true);
            subCategory1.setCreationDate(new Date().toString());
            subCategory1.setMainCategory(category);

            SubCategory subCategory2 = new SubCategory();
            subCategory2.setSubCategoryFarsiName("در انتظار");
            subCategory2.setSubCategoryName("pending");
            subCategory2.setCreationDate(new Date().toString());
            subCategory2.setActive(true);
            subCategory2.setMainCategory(category);

            SubCategory subCategory3 = new SubCategory();
            subCategory3.setSubCategoryFarsiName("رد شده");
            subCategory3.setSubCategoryName("rejected");
            subCategory3.setCreationDate(new Date().toString());
            subCategory3.setActive(true);
            subCategory3.setMainCategory(category);

            List<SubCategory> subCategories = new ArrayList<>();
            subCategories.addAll(Arrays.asList(subCategory1, subCategory2, subCategory3));
            category.setSubCategories(subCategories);
            categoryDA.addCategory(category);
        }
    }
}