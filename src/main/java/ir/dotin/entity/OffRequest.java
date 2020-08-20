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

    @Column(name = "c_offdescription")
    private String offDescription;
    @Column(name = "c_offstartdate")
    private String offStartDate;
    @Column(name = "c_offenddate")
    private String offEndDate;

    @JoinColumn(name = "c_requestpersonid")
    @ManyToOne(cascade = CascadeType.ALL)
    private Person requesterPerson;

    @JoinColumn(name = "c_typeofrequest")
    @ManyToOne(cascade = CascadeType.ALL)
    private SubCategory typeOfRequest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_statusofrequest")
    private SubCategory statusOfRequest;

}

