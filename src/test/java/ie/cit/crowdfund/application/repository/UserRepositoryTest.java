package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.CrowdfundApplication;
import ie.cit.crowdfund.application.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    List<User> list = new ArrayList<>();

    @Test
    public void findById() throws Exception {
        assertEquals("User 1", repository.findOne(1).getFullName());
    }
    @Test
    public void findAll() throws Exception {
        list = (List<User>) repository.findAll();
        assertEquals(3, list.size());
    }
    @Test
    public void findOne() throws Exception {
        User user = repository.findOne(2);
        assertEquals(1000, user.getCredit().intValue());

    }


}