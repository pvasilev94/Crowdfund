package ie.cit.crowdfund.application.repository;

import ie.cit.crowdfund.application.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);

    User findOne(Integer id);

    @Query(value="Select * FROM users WHERE email = :email", nativeQuery = true)
    User findByIdNative(@Param("email") String email);

    @Query(value="Select * FROM users WHERE fullName = :fullName", nativeQuery = true)
    User findByName(@Param("fullName") String fullName);
}
