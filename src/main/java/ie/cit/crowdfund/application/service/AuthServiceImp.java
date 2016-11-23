package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by Pavel on 23/11/2016.
 */
@Service
public class AuthServiceImp implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByIdNative(auth.getName());
        return currentUser;
    }

    @Override
    public boolean isSameWithAuthUser(User user) {
        return user.getEmail().equals(getCurrentUser().getEmail());
    }
}
