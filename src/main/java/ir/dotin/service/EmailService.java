package ir.dotin.service;

import ir.dotin.repository.EmailDA;
import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailDA emailDA;

    public void saveEmail(Email email) {
        Iterator<Person> itr = email.getReceiverPersons().iterator(); // remove all even numbers while (itr.hasNext()) { Integer number = itr.next(); if (number % 2 == 0) { numbers.remove(number); } }

        while (itr.hasNext()) {
            Person person = itr.next();
            if (person.getID() == null) {
                itr.remove();
            }
        }
        emailDA.addEmail(email);

    }

    public List<Email> findAll() {
        List<Email> allEmails = emailDA.findAll();
        return allEmails;
    }

    public List<Email> loadReceivedEmailsByPersonID(Long personId) {
        List<Email> receivedEmailsByPersonId = emailDA.loadReceivedEmailsByPersonId(personId);
        return receivedEmailsByPersonId;
    }
    public List<Email> loadSentEmailsByPersonId(Long personId) {
        List<Email> sentEmailsByPersonId = emailDA.loadSentEmailsByPersonId(personId);
        return sentEmailsByPersonId;
    }


}
