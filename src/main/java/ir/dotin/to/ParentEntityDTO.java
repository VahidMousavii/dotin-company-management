package ir.dotin.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ParentEntityDTO implements Serializable {

    private Long ID;

    private Long version;

    private String creationDate;

    private Boolean active;
}
