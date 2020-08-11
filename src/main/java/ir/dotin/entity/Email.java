package ir.dotin.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity(name = "t_email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email extends Common {
    @ManyToOne
    private Person senderPerson;

    @ManyToMany(mappedBy = "receivedPersonEmails")
    private List<Person> receiverPersons;

    @Lob
    @Column(name = "c_emailAttachment")
    private Blob emailAttachment;
    @Column(name = "c_emailContent")
    private String emailContent;
    @Column(name = "c_emailSubject")
    private String emailSubject;

}
