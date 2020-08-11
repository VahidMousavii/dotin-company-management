package ir.dotin.da;

import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import ir.dotin.entity.SubCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
@Scope("prototype")
public class OffRequestDA {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveOffRequest(OffRequest offRequest) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Person person = session.load(Person.class, offRequest.getRequesterPerson().getC_ID());
            offRequest.setRequesterPerson(person);
            SubCategory subCategory = session.load(SubCategory.class, offRequest.getTypeOfRequest().getC_ID());
            offRequest.setTypeOfRequest(subCategory);
            offRequest.setReceiverManagerPerson(person.getDirectManager());
            Transaction tx = session.beginTransaction();
            session.save(offRequest);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<OffRequest> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from t_offRequest ");
            List<OffRequest> list = query.list();
            tx.commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}