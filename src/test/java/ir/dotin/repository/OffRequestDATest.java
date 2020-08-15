package ir.dotin.repository;

import ir.dotin.entity.OffRequest;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OffRequestDATest extends TestCase {

    @Autowired
    private OffRequestDA offRequestDA;

    @Test
    public void testFindOffRequestByPersonId() {
        List<OffRequest> offRequestByPersonId = offRequestDA.findOffRequestByPersonId(1L);
        for (OffRequest offRequest : offRequestByPersonId) {
            System.out.println(offRequest.getOffDescription());
        }
    }
}