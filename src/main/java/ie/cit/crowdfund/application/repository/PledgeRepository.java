package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.Pledge;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel on 17/11/2016.
 */
public interface PledgeRepository extends CrudRepository<Pledge, Integer> {

    Pledge save(Pledge pledge);

    boolean exists(Integer id);

    Pledge findOne(Integer id);

    Iterable<Pledge> findAll(Iterable<Integer> id);

    Iterable<Pledge> findAll();
}