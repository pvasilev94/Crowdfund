package ie.cit.crowdfund.application.controller;

import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Pavel on 29/11/2016.
 */
@ControllerAdvice
public class CurrentUserController {
    @Autowired
    UserService userService;

    @ModelAttribute("currentUser")
    public User getCurrentUser(@AuthenticationPrincipal User currentUser) {
        currentUser = userService.currentUser();
        System.out.println("The current user is " + currentUser.getEmail());
        return currentUser;
    }
}
