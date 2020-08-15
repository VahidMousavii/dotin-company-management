package ir.dotin.entity;


import lombok.*;

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




}

