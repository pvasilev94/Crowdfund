package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.User;

public interface UserService {

        User findUser(Integer id);
        User findUserByEmail(String email);
}
