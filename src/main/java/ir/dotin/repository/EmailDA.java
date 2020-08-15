package ir.dotin.repository;

import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("prototype")
public class EmailDA {
    @Autowired
    private SessionFactory sessionFactory;

    public void addEmail(Email email) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Person loadedSenderPerson = (Person) session.load(Person.class, email.getSenderPerson().getID());
            List<Person> personReceiverList = new ArrayList<>();
            for (Person receiverPerson : email.getReceiverPersons()) {
                Person loadedReceiverPerson = session.load(Person.class, receiverPerson.getID());
                //todo refactor
//                if (loadedReceiverPerson.getSentEmails() == null) {
//                    List<Email> emailList = new ArrayList<>();
//                    emailList.add(email);
////                    loadedReceiverPerson.setReceivedPersonEmails(emailList);
//                } else {
////                    loadedReceiverPerson.getReceivedPersonEmails().add(email);
//                }
                personReceiverList.add(loadedReceiverPerson);

            }
            email.setSenderPerson(loadedSenderPerson);
            email.setReceiverPersons(personReceiverList);
            session.save(email);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Email> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from t_email ");
            List<Email> list = query.list();
            tx.commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
