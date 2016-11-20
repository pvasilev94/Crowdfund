package ie.cit.crowdfund.application.bean;

import ie.cit.crowdfund.application.entity.Project;
import ie.cit.crowdfund.application.entity.Status;

/**
 * Created by Pavel on 20/11/2016.
 */
public class ProjectBean {
    private int id;
    private int userId;
    private String description;
    private double requiredMoney;
    private double pledge_amount;
    private Status status;

    public ProjectBean() {

    }
    public ProjectBean(Project project) {
        setId(project.getId());
        setUserId(project.getUser().getId());
        setDescription(project.getdescriptionProject());
        setRequiredMoney(project.getrequiredMoney());
        setPledge_amount(project.getPledge_amount());
        setStatus(project.getStatus());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRequiredMoney() {
        return requiredMoney;
    }

    public void setRequiredMoney(double requiredMoney) {
        this.requiredMoney = requiredMoney;
    }

    public double getPledge_amount() {
        return pledge_amount;
    }

    public void setPledge_amount(double pledge_amount) {
        this.pledge_amount = pledge_amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
