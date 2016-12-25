package ie.cit.crowdfund.application.controller;

import ie.cit.crowdfund.application.entity.Pledge;
import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.service.PledgeService;
import ie.cit.crowdfund.application.service.ProjectService;
import ie.cit.crowdfund.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private PledgeService pledgeService;


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
        int projectId = projectService.createProject(user, project.getName(), project.getdescriptionProject(), project.getImage(), project.getrequiredMoney());

        return "redirect:/projects/" + projectId;
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
    public String getProjectById(@PathVariable int id, Model model) {
        Iterable<Pledge> pledges = projectService.findOne(id).getPledgeList();
        model.addAttribute("projects", projectService.findOne(id));
        model.addAttribute("donation", pledges);
        return "task/project";
    }
    @RequestMapping(value = "/projects/{id}/edit", method = RequestMethod.GET)
    public String editProject(Model model,@PathVariable int id) {
        model.addAttribute("project", projectService.findOne(id));
        return "task/editProject";
    }

    @RequestMapping(value = "/projects/{id}/edit", method = RequestMethod.POST)
    public String editProject(@ModelAttribute("project") Project project)  {
        int projectId = projectService.saveProject(project.getId(), project.getdescriptionProject());

        return "redirect:/projects/" + projectId;
    }

    @RequestMapping(value = "/projects/{id}/delete", method = RequestMethod.GET)
    public String deleteProject(Model model,@PathVariable int id)  {
        model.addAttribute("project", projectService.findOne(id));
        return "task/confirmation";
    }

    @RequestMapping(value = "/projects/{id}/delete", method = RequestMethod.POST)
    public String deleteProject(@ModelAttribute("project") Project project,@RequestParam(value="action", required = true)String action)  {
        switch(action) {
            case "delete":
                projectService.delete(project);
                return "redirect:/projects/";
            case "cancel":
                // do nothing go back to projects
        }
        return "redirect:/projects/";
    }

}