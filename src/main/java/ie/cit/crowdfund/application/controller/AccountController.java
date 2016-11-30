//package ie.cit.crowdfund.application.controller;
//
//import ie.cit.crowdfund.application.entity.User;
//import ie.cit.crowdfund.application.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.Assert;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.security.Principal;
//
//@Controller
//class AccountController {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public AccountController(UserRepository accountRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @RequestMapping(value = "account/current", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    @ResponseBody
//    public User accounts(Principal principal) {
//        Assert.notNull(principal);
//        return userRepository.findByIdNative(principal.getName());
//    }
//}
