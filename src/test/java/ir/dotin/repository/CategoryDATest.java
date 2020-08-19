package ir.dotin.repository;

import ir.dotin.entity.SubCategory;
import ir.dotin.to.SubCategoryDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryDATest extends TestCase {

    @Autowired
    private CategoryDA categoryDA;

    @Test
    public void testFindSubCategoryByName() {
/*        SubCategoryDTO rejected = categoryDA.findSubCategoryByName("rejected");
        System.out.println(rejected.getMainCategory().getCategoryName());
        System.out.println(rejected.getSubCategoryName());*/
        for (int i = 0; i <100 ; i++) {
            Random rand = new Random();
            int random = rand.nextInt() & Integer.MAX_VALUE; ;
            System.out.println(random);
        }

    }
}