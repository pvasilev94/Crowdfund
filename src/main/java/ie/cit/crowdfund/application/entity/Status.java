package ie.cit.crowdfund.application.entity;

/**
 * Created by Pavel on 17/11/2016.
 */
public enum Status {
    NOT_FUNDED("Not funded"),
    FUNDED("funded");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
