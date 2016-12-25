package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project save(Project project);

    Project findOne(Integer id);

    Iterable<Project> findAll();

    void delete(Project project);

    List<Project> findByUser(User user);

}
