package ir.dotin.repository;


import ir.dotin.entity.Email;
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

            session.save(person);
            tx.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Person> findAll(Person person) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from t_person tp where tp.c_active = :active");
            query.setParameter("active", person.getC_active());
            List<Person> list = query.list();
            tx.commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void update(Person person) {
        if (person.getC_active() == null) {
            person.setC_active(false);
        }
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Person loadedPerson = session.load(Person.class, person.getC_ID());
            loadedPerson.setPersonName(person.getPersonName());
            loadedPerson.setPersonPhone(person.getPersonPhone());
            session.saveOrUpdate(loadedPerson);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteByID(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete from t_person tp where tp.c_ID = :c_ID");
            query.setParameter("c_ID", id);
            query.executeUpdate();
            tx.commit();
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
            Query query = session.createQuery("from t_person tp where tp.personName like :personName ");
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
            Hibernate.initialize(loadedPerson.getOffRequestList());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return loadedPerson;
    }

    public Person loadPersonWithSentEmails(Long id) {
        Session session = null;
        Person loadedPerson;
        try {
            session = sessionFactory.openSession();
            loadedPerson = session.get(Person.class, id);
            Hibernate.initialize(loadedPerson.getSentEmails());
            for (Email sentEmail : loadedPerson.getSentEmails()) {
                Hibernate.initialize(sentEmail.getReceiverPersons());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return loadedPerson;
    }

    public Person loadPersonWithReceivedEmails(Long id) {
        Session session = null;
        Person loadedPerson;
        try {
            session = sessionFactory.openSession();
            loadedPerson = session.get(Person.class, id);
            Hibernate.initialize(loadedPerson.getReceivedPersonEmails());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return loadedPerson;
    }


    public Person loadPerson(Person person) {
        return this.loadPerson(person.getC_ID());
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

    public void active(Person person) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Person loadedPerson = (Person) session.get(Person.class, person.getC_ID());
            loadedPerson.setC_active(true);
            session.saveOrUpdate(loadedPerson);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deactivate(Person person) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Person loadedPerson = (Person) session.get(Person.class, person.getC_ID());
            loadedPerson.setC_active(false);
            session.saveOrUpdate(loadedPerson);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}