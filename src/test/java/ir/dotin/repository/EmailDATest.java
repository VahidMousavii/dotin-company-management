package ir.dotin.repository;

import ir.dotin.entity.Email;
import ir.dotin.to.EmailDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailDATest extends TestCase {
    @Autowired
    private EmailDA emailDA;

    @Test
    public void testLoadReceivedEmailsByPersonId() {
        List<Email> emailList = emailDA.loadReceivedEmailsByPersonId(2L);
        /*for (Email email : emailList) {
            System.out.println(email.getEmailContent());
            System.out.println("============");
        }*/

        System.out.println(emailList.get(0).getEmailContent());
        System.out.println(emailList);
        System.out.println(emailList);
    }
    @Test
    public void testLoadSentEmailsByPersonId() {
        List<Email> sentEmail = emailDA.loadSentEmailsByPersonId(2L);
        for (Email email : sentEmail) {
            System.out.println(email.getEmailContent());
        }
    }
}