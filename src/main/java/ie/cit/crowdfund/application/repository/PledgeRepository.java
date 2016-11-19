package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.Pledge;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel on 17/11/2016.
 */
public interface PledgeRepository extends CrudRepository<Pledge, String> {

    Pledge save(Pledge pledge);

    boolean exists(String id);

    Pledge findOne(String id);

    Iterable<Pledge> findAll(Iterable<String> id);

    Iterable<Pledge> findAll();
}