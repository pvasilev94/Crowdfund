package ie.cit.crowdfund.application.service;

import ie.cit.crowdfund.application.entity.Pledge;

/**
 * Created by Pavel on 19/11/2016.
 */
public interface PledgeService {

    Pledge findById(Integer id);

    Pledge save(Pledge pledge);

    boolean checkIfExist(Integer id);

    Iterable<Pledge> findAll(Iterable<Integer> id);

    Iterable<Pledge> findAll();
}
