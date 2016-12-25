package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.User;

public interface UserService {
        User save(User user);
        User findUser(Integer id);
        User findUserByEmail(String email);
        User currentUser();
        boolean checkCredit(double amount, User user);
}
