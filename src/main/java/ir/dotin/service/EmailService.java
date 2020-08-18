package ir.dotin.service;

import ir.dotin.entity.Email;
import ir.dotin.repository.EmailDA;
import ir.dotin.to.EmailDTO;
import ir.dotin.to.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailDA emailDA;

    public void saveEmail(EmailDTO emailDTO) throws IOException, SQLException {
        Iterator<PersonDTO> itr = emailDTO.getReceiverPersons().iterator(); // remove all even numbers while (itr.hasNext()) { Integer number = itr.next(); if (number % 2 == 0) { numbers.remove(number); } }

        while (itr.hasNext()) {
            PersonDTO person = itr.next();
            if (person.getID() == null) {
                itr.remove();
            }
        }
        Email email = new Email(emailDTO);
        emailDA.addEmail(email);
    }

    public List<Email> findAll() {
        List<Email> allEmails = emailDA.findAll();
        return allEmails;
    }

    public List<EmailDTO> loadReceivedEmailsByPersonID(Long personId) {
        List<EmailDTO> receivedEmailsByPersonId = emailDA.loadReceivedEmailsByPersonId(personId);

        return receivedEmailsByPersonId;
    }

    public List<EmailDTO> loadSentEmailsByPersonId(Long personId) {
        List<EmailDTO> sentEmailsByPersonId = emailDA.loadSentEmailsByPersonId(personId);
        return sentEmailsByPersonId;
    }

}
