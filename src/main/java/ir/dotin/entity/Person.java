package ir.dotin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends ParentEntity {

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

    @ManyToOne
    @JoinColumn(name = "c_person_directManager_id")
    private Person directManager;
    //Self-Join
    @OneToMany(mappedBy = "directManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> employees;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_role_subcategory")
    private SubCategory roleSubCategory;

    public Person(Long id) {
        super.setID(id);
    }
}

