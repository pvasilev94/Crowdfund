package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public User findUser(Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }


    public User findUserByEmail(String email) {
        User user = userRepository.findByIdNative(email);
        return user;
    }


    public User currentUser() {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        return findUserByEmail(auth.getName());
    }


    public User save(User user) {
        return userRepository.save(user);
    }


    public boolean checkCredit(double amount, User user) {
        if (user.getCredit() >= amount) {
            return true;
        }
        else {
            return false;
        }
    }

    public void refundCredit(User user, double amount) {
        System.out.println("USers credit" + user.getCredit());
        user.setCredit(user.getCredit() + amount);
        userRepository.save(user);
    }
}