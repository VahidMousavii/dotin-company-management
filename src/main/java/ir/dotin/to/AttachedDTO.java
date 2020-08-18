package ir.dotin.to;

import ir.dotin.entity.Category;
import ir.dotin.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachedDTO implements Serializable {
    private byte[] bytes;
    private String fileName;

}
