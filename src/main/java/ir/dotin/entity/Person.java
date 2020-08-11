package ir.dotin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person extends Common {

    @Column(name = "c_personFamily")
    private String personFamily;
    @Column(name = "c_personName")
    private String personName;
    @Column(name = "c_personPhone")
    private String personPhone;
    @Column(name = "c_nationalCode")
    private String nationalCode;
    @Column(name = "c_personnelCode")
    private String personnelCode;

    //yek person mitavanad chandin email daryaft shode dashte bashad
    //va yek email mitavanad be chand nafar ersal shavad(ersale gorohi be chandin nafar)
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "person_received_Emails")
    private List<Email> receivedPersonEmails;

    //email 1 sender darad va har nafar mitavanad chand email ersal konad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderPerson", fetch = FetchType.LAZY)
    private List<Email> sentEmails;

    //yek nafar mitavanad chandin darkhaste morakhasi dashte bashad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requesterPerson", fetch = FetchType.LAZY)
    private List<OffRequest> offRequestList;

    //yek nafar(directManager) mitavanad chandin darkhaste morakhsi baraye taid dashte bashad
    // vali yek darkhaste morakhasi nemitavanad baraye chand nafar baraye taid ersal shavad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiverManagerPerson", fetch = FetchType.LAZY)
    private List<OffRequest> offRequestReceivedList;

    @ManyToOne
    @JoinColumn(name = "c_person_dManager_id")
    private Person directManager;
    //Self-Join
    @OneToMany(mappedBy = "directManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> employees;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_sc")
    private SubCategory roleSubCategory;

    public Person(Long id) {
        super.setC_ID(id);
    }
}

