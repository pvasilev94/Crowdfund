package ie.cit.crowdfund.application.bean;

import ie.cit.crowdfund.application.entity.Pledge;

import java.sql.Timestamp;

/**
 * Created by Pavel on 20/11/2016.
 */
public class PledgeBean {
    private int id;
    private int projectId;
    private int userId;
    private double amount;
    private Timestamp date;

    public PledgeBean(){}

    public PledgeBean(Pledge pledge) {
        setId(pledge.getId());
        setProjectId(pledge.getProjectId().getId());
        setUserId(pledge.getUser().getId());
        setAmount(pledge.getAmount());
        setDate(pledge.getDate());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
