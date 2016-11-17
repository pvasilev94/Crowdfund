package ie.cit.crowdfund.application.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pavel on 17/11/2016.
 */
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String firstName;

    @Column(length = 45)
    private String lastName;

    @Column(length = 80, unique = true)
    private String email;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Pledge> pledges;


    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password, String role,boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Pledge> getPledges() {
        return pledges;
    }

    public void setPledges(List<Pledge> Pledges) {
        this.pledges = Pledges;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfullName() {
        return firstName +" "+ lastName;
    }
}