package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * Created by Pavel on 19/11/2016.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User findUser(Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findByIdNative(email);
        return user;
    }
}
