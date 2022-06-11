package model;

public class UserBrokerPortfolioStock_ideas {

    private String username;
    private int amountOfStockPurchased;
    private String brokerName;
    private String stockIdeasName;

    public UserBrokerPortfolioStock_ideas(String username, int amountOfStockPurchased, String brokerName, String stockIdeasName) {
        this.username = username;
        this.amountOfStockPurchased = amountOfStockPurchased;
        this.brokerName = brokerName;
        this.stockIdeasName = stockIdeasName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAmountOfStockPurchased() {
        return amountOfStockPurchased;
    }

    public void setAmountOfStockPurchased(int amountOfStockPurchased) {
        this.amountOfStockPurchased = amountOfStockPurchased;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getStockIdeasName() {
        return stockIdeasName;
    }

    public void setStockIdeasName(String stockIdeasName) {
        this.stockIdeasName = stockIdeasName;
    }

    @Override
    public String toString() {
        return "userBrokerPortfolioStock_ideas{" +
                "username='" + username + '\'' +
                ", amountOfStockPurchased=" + amountOfStockPurchased +
                ", brokerName='" + brokerName + '\'' +
                ", stockIdeasName='" + stockIdeasName + '\'' +
                '}';
    }
}
