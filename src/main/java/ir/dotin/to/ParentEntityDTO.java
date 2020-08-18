package ir.dotin.to;

import ir.dotin.entity.ParentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParentEntityDTO implements Serializable {

    private Long ID;

    private Long version;

    private String creationDate;

    private Boolean active;

    public ParentEntityDTO(ParentEntity parentEntity) {
        this.ID = parentEntity.getID();
        this.version = parentEntity.getVersion();
        this.creationDate = parentEntity.getCreationDate();
        this.active = parentEntity.getActive();
    }
}
