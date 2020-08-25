package ir.dotin.repository;

import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import ir.dotin.to.AttachedDTO;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
            List<Person> receiverPersonList = new ArrayList<>();
            for (Person receiverPerson : email.getReceiverPersons()) {
                Person loadedReceiverPerson = session.get(Person.class, receiverPerson.getID());
                receiverPersonList.add(loadedReceiverPerson);
            }
            email.setReceiverPersons(receiverPersonList);
            Person loadedSenderPerson = session.get(Person.class, email.getSenderPerson().getID());
            email.setSenderPerson(loadedSenderPerson);
            email.setCreationDate(new Date().toString());
            session.save(email);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public AttachedDTO getEmailAttached(Long emailId) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Email email = session.get(Email.class, emailId);
            AttachedDTO attachedDTO = null;
            if (email.getEmailAttachment() != null) {
                byte[] bytes = email.getEmailAttachment().getBytes(1, (int) email.getEmailAttachment().length());
                attachedDTO = new AttachedDTO(bytes, email.getEmailAttachmentName());

            }
            return attachedDTO;
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

    public List<Email> loadReceivedEmailsByPersonId(Long personId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createSQLQuery("select e.* from t_email e INNER JOIN t_emailreceiverperson mp on e.id=mp.c_emailid where mp.c_personid= :personID")
                    .addEntity(Email.class);
            query.setParameter("personID", personId);
            List<Email> emailList = query.list();
            for (Email email : emailList) {
                Hibernate.initialize(email.getReceiverPersons());
                Hibernate.initialize(email.getSenderPerson());
                if (email.getEmailAttachment() == null) {
                    email.setEmailAttachmentName(null);
                } else {
                    email.setEmailAttachmentName("");
                }
            }
            return emailList;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Email> loadSentEmailsByPersonId(Long personId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Email e where e.senderPerson.ID = :personID");
            query.setParameter("personID", personId);
            List<Email> emails = query.list();
            for (Email email : emails) {
                Hibernate.initialize(email.getReceiverPersons());
                Hibernate.initialize(email.getSenderPerson());
            }
            return emails;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
