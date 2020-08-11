package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//ali hibernate ro gozashtam roo none . mikhai bezar create drop chon roo create drop exception midad
import javax.persistence.*;

@Getter
@Setter
@Table(name = "t_common")
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "person_generator", allocationSize = 1, sequenceName = "person_seq")
    @JoinColumn(name = "c_id", nullable = false)
    private Long c_ID;

    @Column(name = "c_version")
    @Version
    private Long version;

    @Column(name = "c_creationDate")
    private String creationDate;

    private Boolean c_active;
}
