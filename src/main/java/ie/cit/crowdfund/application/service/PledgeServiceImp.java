package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Pledge;
import ie.cit.crowdfund.application.repository.PledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pavel on 19/11/2016.
 */
@Service
public class PledgeServiceImp implements PledgeService {

    @Autowired
    PledgeRepository pledgeRepository;

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
}
