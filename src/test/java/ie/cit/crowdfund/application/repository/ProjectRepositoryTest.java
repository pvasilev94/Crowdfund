package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.CrowdfundApplication;
import ie.cit.crowdfund.application.CrowdfundApplicationTests;
import ie.cit.crowdfund.application.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

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
    @Test
    public void findAll() throws Exception {
        List<Project> list = (List<Project>) repository.findAll();
        assertEquals(8, list.size());
    }


}