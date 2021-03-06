package ir.dotin.entity;

import ir.dotin.to.ParentEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Table(name = "t_entity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class ParentEntity {
    @Id
    @GeneratedValue()
    @JoinColumn(name = "ID", nullable = false)
    private Long ID;
    @Column(name = "c_version")
    @Version
    private Long version;
    @Column(name = "c_creationdate")
    private String creationDate;
    @Column(name = "c_active")
    private Boolean active;
    @Column(name = "c_enable")
    private Boolean enable;
}
