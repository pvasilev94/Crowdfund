package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.CrowdfundApplication;
import ie.cit.crowdfund.application.CrowdfundApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Pavel on 19/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest{

    @Autowired
    ProjectRepository repository;

    @Test
    public void findOne() throws Exception {
        assertEquals("FUNDED", repository.findOne(1).getStatus().toString());
        assertEquals("ProjectTransformers", repository.findOne(1).getName());
    }

}