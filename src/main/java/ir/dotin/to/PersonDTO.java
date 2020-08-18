package ir.dotin.to;

import ir.dotin.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO extends ParentEntityDTO implements Serializable {

    private String personFamily;

    private String personName;

    private String personPhone;

    private String nationalCode;

    private String personnelCode;

    private PersonDTO directManager;
    //Self-Join
    private List<PersonDTO> employees;

    private SubCategoryDTO roleSubCategory;

    public PersonDTO(Long id) {
        super.setID(id);
    }

    public PersonDTO(Person person) {
        super(person);
        this.personFamily = person.getPersonFamily();
        this.personName = person.getPersonName();
        this.personPhone = person.getPersonPhone();
        this.nationalCode = person.getNationalCode();
        this.personnelCode = person.getPersonnelCode();
        if (person.getDirectManager() != null) {
            person.getDirectManager().setDirectManager(null);

            this.directManager = new PersonDTO(person.getDirectManager());
        }
        if (person.getEmployees() != null && person.getEmployees().size() != 0) {

            List<PersonDTO> personEmployeeDTOS = new ArrayList<>();
            for (Person employee : person.getEmployees()) {
                employee.setEmployees(null);
                employee.getDirectManager().setDirectManager(null);
                employee.getDirectManager().setEmployees(null);
                PersonDTO personDTO = new PersonDTO(employee);
                personEmployeeDTOS.add(personDTO);
            }
            this.employees = personEmployeeDTOS;
        }
        this.roleSubCategory = new SubCategoryDTO(person.getRoleSubCategory());
    }

}

