package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.User;

/**
 * Created by Pavel on 23/11/2016.
 */
public interface AuthService {
        User getCurrentUser();
        boolean isSameWithAuthUser(User user);
}
