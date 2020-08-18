package ir.dotin.entity;

import ir.dotin.to.EmailDTO;
import ir.dotin.to.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email extends ParentEntity {

    @ManyToOne
    @JoinColumn(name = "c_sender_person_ID")
    private Person senderPerson;
    @ManyToMany
    @JoinTable(name = "t_emailreceiverperson"
            , joinColumns = {@JoinColumn(name = "C_EMAIL_ID")}
            , inverseJoinColumns = {@JoinColumn(name = "C_PERSON_ID")})
    private List<Person> receiverPersons;
    @Lob
    @Column(name = "c_email_attachment")
    private Blob emailAttachment;
    @Column(name = "c_email_attachment_name")
    private String emailAttachmentName;
    @Column(name = "c_email_content")
    private String emailContent;
    @Column(name = "c_email_subject")
    private String emailSubject;

    public Email(EmailDTO emailDTO) throws IOException, SQLException {
        super(emailDTO);

        this.senderPerson = new Person(emailDTO.getSenderPerson());
        if (emailDTO.getReceiverPersons() != null && emailDTO.getReceiverPersons().size() != 0) {
            this.receiverPersons = new ArrayList<>();
            for (PersonDTO receiverPersonDTO : emailDTO.getReceiverPersons()) {
                receiverPersons.add(new Person(receiverPersonDTO));
            }
        }
        this.emailAttachment = new SerialBlob(emailDTO.getEmailAttachment().getBytes());
        this.emailAttachmentName = emailDTO.getEmailAttachment().getOriginalFilename();
        this.emailContent = emailDTO.getEmailContent();
        this.emailSubject = emailDTO.getEmailSubject();
    }

}
