package ie.cit.crowdfund.application.entity;

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
