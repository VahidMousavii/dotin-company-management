package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Common {
    @Column(name = "c_categoryName")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainCategory", fetch = FetchType.LAZY)
    private List<SubCategory> subCategories;



}
