package ir.dotin.entity;

import ir.dotin.to.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends ParentEntity {

    @Column(name = "c_personfamily")
    private String personFamily;
    @Column(name = "c_personname")
    private String personName;
    @Column(name = "c_personphone")
    private String personPhone;
    @Column(name = "c_nationalcode")
    private String nationalCode;
    @Column(name = "c_personnelcode")
    private String personnelCode;
    @ManyToOne
    @JoinColumn(name = "c_persondirectmanagerid")
    private Person directManager;
    //Self-Join
    @OneToMany(mappedBy = "directManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> employees;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_rolesubcategory")
    private SubCategory roleSubCategory;

    public Person(PersonDTO personDTO) {
        super(personDTO);
        this.personFamily = personDTO.getPersonFamily();
        this.personName = personDTO.getPersonName();
        this.personPhone = personDTO.getPersonPhone();
        this.nationalCode = personDTO.getNationalCode();
        this.personnelCode = personDTO.getPersonnelCode();
        this.roleSubCategory = new SubCategory(personDTO.getRoleSubCategory());
        if (personDTO.getDirectManager() != null) {
            this.directManager = new Person(personDTO.getDirectManager());
        }
        if (personDTO.getEmployees() != null && personDTO.getEmployees().size() != 0) {
            List<Person> employeesPerson = new ArrayList<>();
            for (PersonDTO employee : personDTO.getEmployees()) {
                Person employeePerson = new Person(employee);
                employeesPerson.add(employeePerson);
            }
            this.employees = employeesPerson;
        }

    }


    public Person(Long id) {
        super.setID(id);
    }
}

