package ir.dotin.entity;


import lombok.*;

import javax.persistence.*;

@Entity(name = "t_offRequest")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OffRequest extends Common {

    @Column(name = "c_offDescription")
    private String offDescription;
    @Column(name = "c_offStartDate")
    private String offStartDate;
    @Column(name = "c_offEndDate")
    private String offEndDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person requesterPerson;
    @ManyToOne(cascade = CascadeType.ALL)
    private Person receiverManagerPerson;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubCategory typeOfRequest;


}

