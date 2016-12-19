package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.Pledge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Pavel on 17/11/2016.
 */
public interface PledgeRepository extends CrudRepository<Pledge, Integer> {

    Pledge save(Pledge pledge);

    boolean exists(Integer id);

    Pledge findOne(Integer id);

    Iterable<Pledge> findAll(Iterable<Integer> id);

    Iterable<Pledge> findAll();

    @Query(value="Select * FROM pledges WHERE project = :project", nativeQuery = true)
    Iterable<Pledge> findAllByProjectId(@Param("project")Integer id);
}