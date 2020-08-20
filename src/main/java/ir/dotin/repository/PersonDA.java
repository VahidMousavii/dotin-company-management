package ir.dotin.repository;


import ir.dotin.entity.Person;
import ir.dotin.entity.SubCategory;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDA {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person person) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            if (person.getDirectManager() != null) {
                Person loadedDirectManagerPerson = session.load(Person.class, person.getDirectManager().getID());
                person.setDirectManager(loadedDirectManagerPerson);
            }
            SubCategory loadSubCat = session.load(SubCategory.class, person.getRoleSubCategory().getID());
            person.setRoleSubCategory(loadSubCat);
            session.save(person);
            tx.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Person> findAll(Boolean isActive) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Person tp where tp.active = :active");
            query.setParameter("active", isActive);
            List<Person> list = query.list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Person> findAllActiveManagers() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Person tp where tp.roleSubCategory.subCategoryName like :managerRole and tp.active = true");
            query.setParameter("managerRole", "manager");
            List<Person> list = query.list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Person person) {
        if (person.getActive() == null) {
            person.setActive(false);
        }
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Person loadedPerson = session.load(Person.class, person.getID());
            loadedPerson.setPersonName(person.getPersonName());
            loadedPerson.setPersonPhone(person.getPersonPhone());
            loadedPerson.setPersonFamily(person.getPersonFamily());
            loadedPerson.setActive(person.getActive());
            session.saveOrUpdate(loadedPerson);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Person> findByName(String name) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Person tp where tp.personName like :personName ");
            query.setParameter("personName", name);
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Person loadPerson(Long id) {
        Session session = null;
        Person loadedPerson;
        try {
            session = sessionFactory.openSession();
            loadedPerson = session.get(Person.class, id);
            return loadedPerson;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Person loadPersonWithSentEmails(Long id) {
        Session session = null;
        Person loadedPerson;
        try {
            session = sessionFactory.openSession();
            loadedPerson = session.get(Person.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return loadedPerson;
    }


    public Person loadPerson(Person person) {
        return this.loadPerson(person.getID());
    }


    public void saveRole(SubCategory subCategory) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(subCategory);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void active(Long personId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Person loadedPerson = session.get(Person.class, personId);
            loadedPerson.setActive(true);
            session.saveOrUpdate(loadedPerson);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deactivate(Long personId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Person loadedPerson = session.get(Person.class, personId);
            loadedPerson.setActive(false);
            session.saveOrUpdate(loadedPerson);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}