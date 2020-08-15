package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity(name = "t_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Entity {
    @Column(name = "c_category_name")
    private String categoryName;

    @JoinColumn(name = "c_main_category_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubCategory> subCategories;



}
