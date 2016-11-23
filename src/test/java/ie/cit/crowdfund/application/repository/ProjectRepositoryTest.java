package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.CrowdfundApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Pavel on 19/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class ProjectRepositoryTest extends CrowdfundApplication{

    @Autowired
    ProjectRepository repository;

    @Test
    public void findOne() throws Exception {
        assertEquals("FUNDEDs", repository.findOne(1).getStatus().toString());
        assertEquals("ProjectTransformers", repository.findOne(1).getName());
    }

}