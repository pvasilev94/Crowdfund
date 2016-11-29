package ie.cit.crowdfund.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SigninController {

	@RequestMapping(value = "signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Invalid password");
        }
        if (logout != null) {
            modelAndView.addObject("logout", "You've been logged out successfully");
        }
        modelAndView.setViewName("signin/signin");
        return modelAndView;
    }
}
