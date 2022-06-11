package model;

public class UsersByBroker {

    private String brokerName;
    private long numberOfUsers;

    public UsersByBroker(String brokerName, long numberOfUsers) {
        this.brokerName = brokerName;
        this.numberOfUsers = numberOfUsers;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public long getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(long numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public String toString() {
        return "UsersByBroker{" +
                "brokerName='" + brokerName + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }
}
