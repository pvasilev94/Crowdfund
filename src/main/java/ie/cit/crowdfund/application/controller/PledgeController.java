package ie.cit.crowdfund.application.controller;

import ie.cit.crowdfund.application.service.PledgeService;
import ie.cit.crowdfund.application.service.ProjectService;
import ie.cit.crowdfund.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pavel on 19/12/2016.
 */
@Controller
class PledgeController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private PledgeService pledgeService;


    @RequestMapping(value = "donations", method = RequestMethod.GET)
    public String allProjects(Model model) {

        model.addAttribute("donations", pledgeService.findAll());
        return "task/donationlist";
    }
}