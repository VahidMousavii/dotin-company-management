package ir.dotin.service;

import ir.dotin.entity.Email;
import ir.dotin.exception.DotinException;
import ir.dotin.repository.EmailDA;
import ir.dotin.to.AttachedDTO;
import ir.dotin.to.EmailDTO;
import ir.dotin.to.PersonDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private ModelMapper modelMapper;
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
        Email email = modelMapper.map(emailDTO, Email.class);
        SerialBlob serialBlob = new SerialBlob(emailDTO.getMultipartFileEmailAttachFile().getBytes());
        String originalFilename = emailDTO.getMultipartFileEmailAttachFile().getOriginalFilename();
        email.setEmailAttachment(serialBlob);
        email.setEmailAttachmentName(originalFilename);
        emailDA.addEmail(email);
    }

    public AttachedDTO getEmailAttached(EmailDTO emailDTO) throws SQLException, DotinException {

        AttachedDTO emailAttached = emailDA.getEmailAttached(emailDTO.getID());
        if (emailAttached==null){
            throw new DotinException("فایل پیوست وجود ندارد");
        }
        return emailAttached;
    }

    public List<EmailDTO> findAll() {
        List<Email> allEmails = emailDA.findAll();
        List<EmailDTO> emailDTOS = modelMapper.map(allEmails, new TypeToken<List<EmailDTO>>() {
        }.getType());
        return emailDTOS;
    }

    public List<EmailDTO> loadReceivedEmailsByPersonID(Long personId) {
        List<Email> emailList = emailDA.loadReceivedEmailsByPersonId(personId);

        List<EmailDTO> emailDTOS = modelMapper.map(emailList, new TypeToken<List<EmailDTO>>() {
        }.getType());
        return emailDTOS;
    }

    public List<EmailDTO> loadSentEmailsByPersonId(Long personId) {
        List<Email> emailList = emailDA.loadSentEmailsByPersonId(personId);
        List<EmailDTO> emailDTOS = modelMapper.map(emailList, new TypeToken<List<EmailDTO>>() {
        }.getType());
        return emailDTOS;
    }

}
