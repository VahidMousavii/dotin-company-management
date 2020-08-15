package ir.dotin.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
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

    @OneToMany
    @JoinTable(name = "t_emailreceiverperson"
        , joinColumns = {@JoinColumn(name = "C_EMAIL_ID")}
        , inverseJoinColumns = {@JoinColumn(name = "C_PERSON_ID")})
    private List<Person> receiverPersons;

    @Lob
    @Column(name = "c_email_attachment")
    private Blob emailAttachment;
    @Column(name = "c_email_content")
    private String emailContent;
    @Column(name = "c_email_subject")
    private String emailSubject;

}
