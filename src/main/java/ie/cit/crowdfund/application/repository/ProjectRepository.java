package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel on 17/11/2016.
 */
public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project save(Project project);

    Project findOne(Integer integer);

    Iterable<Project> findAll();
}
