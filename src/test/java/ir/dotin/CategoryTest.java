package ir.dotin;
import ir.dotin.repository.CategoryDA;
import ir.dotin.entity.Category;
import ir.dotin.entity.SubCategory;

import java.util.Arrays;

public class CategoryTest {

    public static void main(String[] args) {
        addPersonRoleCategory();
        addOffRequestCategory();
    }
    //Creating Cat & SubCat for OffRequest
    private static void addOffRequestCategory() {
        Category category = new Category();
        category.setCategoryName("OffRequestType");

        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName("Hourly");
        subCategory.setSubCategoryFarsiName("ساعتی");
        subCategory.setMainCategory(category);


        SubCategory subCategory2 = new SubCategory();
        subCategory2.setSubCategoryName("Daily");
        subCategory2.setSubCategoryFarsiName("روزانه");
        subCategory2.setMainCategory(category);

        if (category.getSubCategories() != null) {
            category.getSubCategories().addAll(Arrays.asList(subCategory, subCategory2));
        } else {
            category.setSubCategories(Arrays.asList(subCategory, subCategory2));
        }
        CategoryDA categoryDA = new CategoryDA();
        categoryDA.addCategory(category);
    }
    //Creating Cat & SubCat for Role
    private static void addPersonRoleCategory() {
        Category category = new Category();
        category.setCategoryName("PersonRole");

        SubCategory developer = new SubCategory();
        SubCategory tester = new SubCategory();

        developer.setSubCategoryName("Developer");
        developer.setSubCategoryFarsiName("برنامه نویس");
        tester.setSubCategoryName("Tester");
        tester.setSubCategoryFarsiName("تستر");

        category.setSubCategories(Arrays.asList(developer, tester));

        developer.setMainCategory(category);
        tester.setMainCategory(category);

        CategoryDA categoryDA = new CategoryDA();
        categoryDA.addCategory(category);
    }

}