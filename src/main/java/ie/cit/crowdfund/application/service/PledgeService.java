package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Pledge;
import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.Status;
import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.PledgeRepository;
import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PledgeService {

    @Autowired
    PledgeRepository pledgeRepository;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;


    public Pledge findById(Integer id) {
        return pledgeRepository.findOne(id);
    }


    public Pledge save(Pledge pledge) {
        return pledgeRepository.save(pledge);
    }

    public Pledge findOne(Integer id) { return pledgeRepository.findOne(id) ;}

    public boolean checkIfExist(Integer id) {
        return pledgeRepository.exists(id);
    }


    public Iterable<Pledge> findAll(Iterable<Integer> id) {
        return pledgeRepository.findAll(id);
    }


    public Iterable<Pledge> findAll() {
        return pledgeRepository.findAll();
    }


    public Iterable<Pledge> finddAllByProjectId(Integer id) {
        return null;
    }


    public boolean addPledgeForProject(Pledge pledge) {
        Status projectSTATUS;
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
//                if (project.getStatus() == Status.NOT_FUNDED) {
                    status = true;
//                }
            }
        }
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

            //update the pledge repo as well
            pledgeRepository.save(donate);
        }
        return status;
    }
    // TODO change to boolean at later stage to be able to get confirmation in the controller
    public void cancelDonation(Pledge pledge) {
        System.out.println("USers credit" + pledge.getUser().getCredit());
        userService.refundCredit(pledge.getUser(), pledge.getAmount());
            projectService.updateProjectOnDonationCancellation(pledge.getProject(), pledge.getAmount());
            pledgeRepository.delete(pledge);

    }

    public Iterable<Pledge> findAllForCurrentUser() {
        System.out.println(pledgeRepository.findAll(userService.currentUser().getId()));
        return pledgeRepository.findAll(userService.currentUser().getId());
    }
}
