package ie.cit.crowdfund.application.controller;

import ie.cit.crowdfund.application.repository.ProjectRepository;
import ie.cit.crowdfund.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
class ProjectController {
//    @Autowired
//    private ProjectService projectService;

    @Autowired
    private ProjectService projectService;

    @ModelAttribute("page")
    public String module() {
        return "projects";
    }

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "task/list";
    }
}