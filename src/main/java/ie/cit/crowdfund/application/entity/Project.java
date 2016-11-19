package ie.cit.crowdfund.application.entity;

import ie.cit.crowdfund.application.utils.NewFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "projects")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double requiredMoney;

    @Column
    @Type(type = "text")
    private String descriptionProject;

    @Column
    private String image;

    @Column
    private double Pledge_amount;

    @Column
    private Timestamp date;

    @Enumerated
    private Status status;

    @Column(name = "project_name")
    private String name;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "project")
    private List<Pledge> PledgeList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;


    public Project() {
    }

    public Project(User user, double requiredMoney, String descriptionProject, String image, double Pledge_amount, Timestamp date, Status status, String name, List<Pledge> PledgeList) {
        this.user = user;
        this.requiredMoney = requiredMoney;
        this.descriptionProject = descriptionProject;
        this.image = image;
        this.Pledge_amount = Pledge_amount;
        this.date = date;
        this.status = status;
        this.name = name;
        this.PledgeList = PledgeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(int userId) {
        this.user = user;
    }

    public double getrequiredMoney() {
        return requiredMoney;
    }

    public void setrequiredMoney(double requiredMoney) {
        this.requiredMoney = requiredMoney;
    }

    public String getdescriptionProject() {
        return descriptionProject;
    }

    public void setdescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPledge_amount() {
        return PledgeList.stream().mapToDouble(Pledge::getAmount).sum();
    }

    public void setPledge_amount(double Pledge_amount) {
        this.Pledge_amount = Pledge_amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pledge> getPledgeList() {
        return PledgeList;
    }

    public void setPledgeList(List<Pledge> PledgeList) {
        this.PledgeList = PledgeList;
    }

    public double percentPledge() {
        double percent = getPledge_amount() / requiredMoney * 100;
        return NewFormat.roundNumber(percent);
    }

    public boolean finishedProject() {
//        if (percentPledge() >= FINISHED)
//        {
//            return true;
//        }
//        else {
//            return false;
//        }
        return true;
    }

    public String dateFormat() {
        return "" + date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);
    }
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", user=" + user +
                ", requiredMoney=" + requiredMoney +
                ", descriptionProject='" + descriptionProject + '\'' +
                ", image='" + image + '\'' +
                ", Pledge_amount=" + Pledge_amount +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", PledgeList=" + PledgeList +
                '}';
    }
}
