package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Pledge;
import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.PledgeRepository;
import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PledgeServiceImp implements PledgeService {

    @Autowired
    PledgeRepository pledgeRepository;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Override
    public Pledge findById(Integer id) {
        return pledgeRepository.findOne(id);
    }

    @Override
    public Pledge save(Pledge pledge) {
        return pledgeRepository.save(pledge);
    }

    @Override
    public boolean checkIfExist(Integer id) {
        return pledgeRepository.exists(id);
    }

    @Override
    public Iterable<Pledge> findAll(Iterable<Integer> id) {
        return pledgeRepository.findAll(id);
    }

    @Override
    public Iterable<Pledge> findAll() {
        return pledgeRepository.findAll();
    }

    @Override
    public Iterable<Pledge> finddAllByProjectId(Integer id) {
        return null;
    }

    @Override
    public boolean addPledgeForProject(Pledge pledge) {
        Project project = pledge.getProject();
        User user = userService.currentUser();
        Pledge donate = new Pledge();

        //added to always create a sequenced pledge id cause otherwise hibernate throws unique index constraint
        //error was because I set uniqueConstraints in entity class however this way sequenced pledge list can be kept for a record of deleted pledges
        List<Pledge> list = (List<Pledge>) pledgeRepository.findAll();
        donate.setId(list.size() + 1);


        donate.setDate(new Timestamp(System.currentTimeMillis()));
        donate.setAmount(pledge.getAmount());
        donate.setUser(pledge.getUser());
        donate.setProject(pledge.getProject());

        boolean status1 = userService.checkCredit(pledge.getAmount(), pledge.getUser());
        boolean status2 = projectService.checkProject(pledge.getAmount(), pledge.getProject());
        boolean status = false;
        if (status1) {
            if (status2){
                status = true;
            }
        }
        pledgeRepository.save(donate);
        if (status)
        {
            //update User credit amount
            double previous = user.getCredit();
            double donation = pledge.getAmount();
            user.setCredit(previous - donation);
            userService.save(user);

            //update Project's requiredMoney
            double current = project.getrequiredMoney();
            project.setrequiredMoney(current - donation);
            projectService.save(project);
        }
        return status;
    }

    @Override
    public Iterable<Pledge> findAllForCurrentUser() {
        System.out.println(pledgeRepository.findAll(userService.currentUser().getId()));
        return pledgeRepository.findAll(userService.currentUser().getId());
    }
}
