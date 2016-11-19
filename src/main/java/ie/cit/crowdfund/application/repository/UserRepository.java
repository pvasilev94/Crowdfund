package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Pavel on 17/11/2016.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findById(String id);

}
