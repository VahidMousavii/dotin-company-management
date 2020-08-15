package ir.dotin.repository;

import ir.dotin.entity.Category;
import ir.dotin.entity.SubCategory;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Scope("prototype")
public class CategoryDA {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category) {

        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(category);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public SubCategory findByName(String name) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from t_subCategory sc where sc.subCategoryName like :name");
            query.setParameter("name", name);
            SubCategory subCategory = (SubCategory) query.uniqueResult();
//            Hibernate.initialize(subCategory.getOffRequestList());
            return subCategory;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public Category findCategoryById(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Category c where c.ID= :categoryId");
            query.setParameter("categoryId", id);
            Category category = (Category) query.uniqueResult();
            Hibernate.initialize(category.getSubCategories());
            return category;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<SubCategory> findSubCategoriesByName(String categoryName) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Category c where c.categoryName like :categoryName");
            query.setParameter("categoryName", categoryName);
            Category category = (Category) query.uniqueResult();
            Hibernate.initialize(category.getSubCategories());
            List<SubCategory> subCategories = category.getSubCategories();
            return subCategories;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public SubCategory findSubCategoryByName(String subCategoryName) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from SubCategory sc where sc.subCategoryName like :subCategoryName");
            query.setParameter("subCategoryName", subCategoryName);
            SubCategory subCategory = (SubCategory) query.uniqueResult();
            return subCategory;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
