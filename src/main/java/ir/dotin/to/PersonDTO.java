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
}

