package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;

import java.util.List;

/**
 * Created by Pavel on 19/11/2016.
 */
public interface ProjectService {

    Project save(Project project);

    Project findOne(Integer id);

    Iterable<Project> findAll();

    void delete(Project project);

    List<Project> findByUser(User user);

    int createProject(User user, String projectName, String projectDescription, String image, double amount);

    int saveProject(int id, String description);

    boolean checkProject(double amount, Project project);
}
