package ir.dotin.to;


import ir.dotin.entity.OffRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OffRequestDTO extends ParentEntityDTO implements Serializable {

    private String offDescription;
    private String offStartDate;
    private String offEndDate;
    private PersonDTO requesterPerson;
    private SubCategoryDTO typeOfRequest;
    private SubCategoryDTO statusOfRequest;

}

