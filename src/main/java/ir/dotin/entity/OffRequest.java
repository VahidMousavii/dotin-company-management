package ir.dotin.entity;


import ir.dotin.to.OffRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_offrequest")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OffRequest extends ParentEntity {

    @Column(name = "c_off_description")
    private String offDescription;
    @Column(name = "c_off_startDate")
    private String offStartDate;
    @Column(name = "c_off_endDate")
    private String offEndDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person requesterPerson;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubCategory typeOfRequest;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubCategory statusOfRequest;

    public OffRequest(OffRequestDTO offRequestDTO){
        super(offRequestDTO);
        this.offDescription=offRequestDTO.getOffDescription();
        this.offStartDate=offRequestDTO.getOffStartDate();
        this.offEndDate=offRequestDTO.getOffEndDate();
        this.requesterPerson=new Person(offRequestDTO.getRequesterPerson());
        this.typeOfRequest=new SubCategory(offRequestDTO.getTypeOfRequest());
        this.statusOfRequest=new SubCategory(offRequestDTO.getStatusOfRequest());
    }

}

