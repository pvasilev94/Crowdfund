package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Pledge;
import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserService userService;

    @Autowired
    PledgeService pledgeService;


    public Project save(Project project) {
        return projectRepository.save(project);
    }


    public Project findOne(Integer id) {
        return projectRepository.findOne(id);
    }


    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }


    public void delete(Project project) {
        projectRepository.delete(project);
    }


    public List<Project> findByUser(User user) {
        return projectRepository.findByUser(user);
    }


    public int createProject(User user, String projectName, String projectDescription, String image, double amount) {
        Project project = new Project();
        project.setName(projectName);
        project.setdescriptionProject(projectDescription);
        project.setImage(image);
        project.setrequiredMoney(amount);
        project.setUser(userService.currentUser());
//        project.setDate();
        projectRepository.save(project);
        return project.getId();
    }


    public boolean checkProject(double amount, Project project) {
        if (project.getrequiredMoney() >= amount) {
            return true;
        }
        else {
            return false;
        }
    }

    public int saveProject(int id, String description) {
        Project project = new Project();
        project = findOne(id);
        project.setdescriptionProject(description);
        save(project);
        return project.getId();
    }
    public void updateProjectOnDonationCancellation(Project project, double amount) {
        project.setrequiredMoney(project.getrequiredMoney() + amount);
        projectRepository.save(project);
    }

    /**
     * On project delete pledges are returned to the donators if the project is not complete.
     * @param project
     */
    //add Transactional to keep the persistence context
    @Transactional
    public void onProjectDelete(Project project) {
        List<Pledge> pledgeList = project.getPledgeList();
        List<Pledge> dummyList = pledgeList;
        int counter = 0;
        while (pledgeList.size() > counter) {
            for (Pledge pledge : pledgeList) {
                pledgeService.cancelDonation(pledgeService.findOne(pledge.getId()));
                counter ++;
            }
        }
            delete(project);
    }
}
