package model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stock_id;
    private String name;
    private String ticker;
    private float current_price;
    private String news_of_the_company;
    private String country;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(float current_price) {
        this.current_price = current_price;
    }

    public String getNews_of_the_company() {
        return news_of_the_company;
    }

    public void setNews_of_the_company(String news_of_the_company) {
        this.news_of_the_company = news_of_the_company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock_id=" + stock_id +
                ", name='" + name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", current_price=" + current_price +
                ", news_of_the_company='" + news_of_the_company + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
