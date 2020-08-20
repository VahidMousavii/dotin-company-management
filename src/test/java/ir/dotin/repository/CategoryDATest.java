package ir.dotin.repository;

import ir.dotin.entity.Person;
import ir.dotin.to.PersonDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int random = rand.nextInt() & Integer.MAX_VALUE;
            ;
            System.out.println(random);
        }

        ModelMapper modelMapper = new ModelMapper();
// user here is a prepopulated User instance
        Person person = new Person();
        person.setPersonName("ali");
        person.setID(2L);
        person.setPersonFamily("karimipour");
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        System.out.println(personDTO.getPersonFamily());
        System.out.println(personDTO.getPersonName());
        System.out.println(personDTO.getID());
    }

    @Test
    public void testModelMapper() {

        ModelMapper modelMapper = new ModelMapper();
// user here is a prepopulated User instance
        Person person = new Person();
        person.setPersonName("ali");
        person.setID(2L);
        person.setPersonFamily("karimipour");
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        System.out.println(personDTO.getPersonFamily());
        System.out.println(personDTO.getPersonName());
        System.out.println(personDTO.getID());
    }

}
