package ir.dotin.to;

import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO extends ParentEntityDTO implements Serializable {

    private PersonDTO senderPerson;

    private List<PersonDTO> receiverPersons;

    private MultipartFile emailAttachment;

    private String emailAttachmentName;

    private String emailAttachmentLink;

    private String emailContent;

    private String emailSubject;

    public EmailDTO(Email email) {
        super(email);
        this.senderPerson = new PersonDTO(email.getSenderPerson());
        if (email.getReceiverPersons() != null && email.getReceiverPersons().size() != 0) {
            List<PersonDTO> receiverPersonDTOs = new ArrayList<>();
            for (Person receiverPerson : email.getReceiverPersons()) {
                PersonDTO personDTO = new PersonDTO(receiverPerson);
                receiverPersonDTOs.add(personDTO);
            }
            this.receiverPersons = receiverPersonDTOs;
        }
        this.emailAttachmentLink = "someServlet.do" + email.getID();
        this.emailAttachmentName = email.getEmailAttachmentName();
        this.emailContent = email.getEmailContent();
        this.emailSubject = email.getEmailSubject();
    }

}