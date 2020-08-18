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

    public OffRequestDTO(OffRequest offRequest) {
        super(offRequest);
        this.offDescription = offRequest.getOffDescription();
        this.offStartDate = offRequest.getOffStartDate();
        this.offEndDate = offRequest.getOffEndDate();
        this.requesterPerson = new PersonDTO(offRequest.getRequesterPerson());
        this.typeOfRequest = new SubCategoryDTO(offRequest.getTypeOfRequest());
        this.statusOfRequest = new SubCategoryDTO(offRequest.getStatusOfRequest());
    }

}

