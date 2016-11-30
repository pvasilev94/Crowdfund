package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 19/11/2016.
 */
@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findOne(Integer id) {
        return projectRepository.findOne(id);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }
    @Override
    public List<Project> findByUser(User user) {
        return projectRepository.findByUser(user);
    }

    @Override
    public int createProject(User user, String projectName, String projectDescription, String image, double amount) {
        Project project = new Project();
        project.setName(projectName);
        project.setdescriptionProject(projectDescription);
        project.setImage(image);
        project.setrequiredMoney(amount);
        projectRepository.save(project);
        return project.getId();
    }
}
