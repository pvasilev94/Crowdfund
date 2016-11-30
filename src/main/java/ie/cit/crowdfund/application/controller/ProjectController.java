package ie.cit.crowdfund.application.controller;

import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.ProjectRepository;
import ie.cit.crowdfund.application.service.ProjectService;
import ie.cit.crowdfund.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public String allProjects(Model model) {

        model.addAttribute("projects", projectService.findAll());
        return "task/list";
    }
    @RequestMapping(value = "myprojects", method = RequestMethod.GET)
    public String myProjects(Model model) {

        model.addAttribute("projects", projectService.findByUser(userService.currentUser()));
        return "task/list";
    }
    @RequestMapping(value = "createprojects", method = RequestMethod.GET)
    public String createProject(Model model) {
        model.addAttribute("project", new Project());
        return "task/createProject";
    }

    @RequestMapping(value = "createprojects", method = RequestMethod.POST)
    public String createProject(@ModelAttribute("project") Project project)  {
        System.out.println("Project values " + project.getName() + " " + project.getrequiredMoney() + " " + project.getdescriptionProject() + " " + project.getImage());
        User user = new User();
//        user = userService.currentUser();
        int projectId = projectService.createProject(user, project.getName(), project.getdescriptionProject(), project.getImage(), project.getrequiredMoney());
        return "redirect:/";
    }
}