package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends ParentEntity {
    @Column(name = "c_personname")
    private String personName;
    @Column(name = "c_personfamily")
    private String personFamily;
    @Column(name = "c_personphone")
    private String personPhone;
    @Column(name = "c_nationalcode")
    private String nationalCode;
    @Column(name = "c_personnelcode")
    private String personnelCode;
    //Self-Join
    @ManyToOne
    @JoinColumn(name = "c_persondirectmanagerid")
    private Person directManager;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_rolesubcategory")
    private SubCategory roleSubCategory;

    public Person(Long id) {
        super.setID(id);
    }
}