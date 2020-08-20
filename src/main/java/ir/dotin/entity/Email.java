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
    @JoinColumn(name = "c_senderpersonid")
    private Person senderPerson;
    @ManyToMany
    @JoinTable(name = "t_emailreceiverperson"
            , joinColumns = {@JoinColumn(name = "c_emailid")}
            , inverseJoinColumns = {@JoinColumn(name = "c_personid")})
    private List<Person> receiverPersons;
    @Lob
    @Column(name = "c_emailattachment")
    private Blob emailAttachment;
    @Column(name = "c_emailattachmentname")
    private String emailAttachmentName;
    @Column(name = "c_emailcontent")
    private String emailContent;
    @Column(name = "c_emailsubject")
    private String emailSubject;

}
