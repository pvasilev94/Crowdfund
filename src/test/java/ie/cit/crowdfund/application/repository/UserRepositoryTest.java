package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.CrowdfundApplication;
import ie.cit.crowdfund.application.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pavel on 20/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
// needs to extend CrowdfundApplication to load Application context
public class UserRepositoryTest extends CrowdfundApplication {

    @Autowired
    UserRepository repository;


    @Test
    public void findById() throws Exception {
        assertEquals("Jenna Smith", repository.findOne(1).getFullName());

    }

}