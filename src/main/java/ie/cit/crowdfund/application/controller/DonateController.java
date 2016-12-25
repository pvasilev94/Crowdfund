package ie.cit.crowdfund.application.controller;

import ie.cit.crowdfund.application.entity.Pledge;
import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.service.PledgeService;
import ie.cit.crowdfund.application.service.ProjectService;
import ie.cit.crowdfund.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DonateController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private PledgeService pledgeService;

    @RequestMapping(value = "donations", method = RequestMethod.GET)
    public String allDonation(Model model) {

        model.addAttribute("donations", pledgeService.findAllForCurrentUser());
        return "task/donationlist";
    }

    @RequestMapping(value = "/projects/{id}/donate", method = RequestMethod.GET)
    public String donateProject(Model model, @PathVariable int id) {
        model.addAttribute("project", projectService.findOne(id));
        model.addAttribute("donate", new Pledge());
        return "task/donate";
    }

    @RequestMapping(value = "/projects/{id}/donate", method = RequestMethod.POST)
    public String donateProject(@PathVariable int id,@ModelAttribute Pledge amount,@RequestParam(value="action", required = true)String action)  {
        Project project = projectService.findOne(id);
        Pledge pledge = new Pledge();
        pledge.setAmount(amount.getAmount());
        pledge.setProject(project);
        pledge.setUser(userService.currentUser());
        switch(action) {
            case "donate":
                if (pledgeService.addPledgeForProject(pledge))
                return "redirect:/projects/";
            case "cancel":
                // do nothing go back to projects
        }
        return "redirect:/projects/";
    }
    @RequestMapping(value = "/donations/{id}/cancel", method = RequestMethod.GET)
    public String cancelDonation(Model model,@PathVariable int id)  {
        model.addAttribute("donation", pledgeService.findOne(id));
        return "task/confirmationDonation";
    }

    @RequestMapping(value = "/projects/{id}/delete", method = RequestMethod.POST)
    public String cancelDonation(@ModelAttribute("donation") Pledge pledge,@RequestParam(value="action", required = true)String action)  {
        switch(action) {
            case "delete":
                pledgeService.cancelDonation(pledge);
                return "redirect:/projects/" + pledge.getProject().getId();
            case "cancel":
                // do nothing go back to projects
        }
        return "redirect:/projects/";
    }
}
