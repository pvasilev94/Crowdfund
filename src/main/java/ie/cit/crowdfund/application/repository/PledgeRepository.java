package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.Pledge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PledgeRepository extends CrudRepository<Pledge, Integer> {

    Pledge save(Pledge pledge);

    boolean exists(Integer id);

    Pledge findOne(Integer id);

    Iterable<Pledge> findAll(Iterable<Integer> id);

    Iterable<Pledge> findAll();

    @Query(value="Select * FROM pledges WHERE user_id = :user_id", nativeQuery = true)
    Iterable<Pledge> findAll(@Param("user_id")Integer id);

    @Query(value="Select * FROM pledges WHERE project = :project", nativeQuery = true)
    Iterable<Pledge> findAllByProjectId(@Param("project")Integer id);
}