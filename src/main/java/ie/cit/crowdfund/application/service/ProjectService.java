package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Project;

import java.util.List;

/**
 * Created by Pavel on 19/11/2016.
 */
public interface ProjectService {

    Project save(Project project);

    Project findOne(Integer id);

    Iterable<Project> findAll();

    void delete(Project project);

    List<Project> findByUser(String Id);
}
