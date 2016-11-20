package ie.cit.crowdfund.application.bean;

import ie.cit.crowdfund.application.entity.User;

/**
 * Created by Pavel on 20/11/2016.
 */
public class UserBean {
    private int id;
    private double credit;


    public UserBean() {
    }
    public UserBean(User user) {
        setId(user.getId());
        setCredit(user.getCredit());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
