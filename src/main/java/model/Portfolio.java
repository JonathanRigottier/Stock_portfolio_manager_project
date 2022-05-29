package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int portfolio_id;
    private int amount_of_stock_purchased;
    private float single_stock_purchased_price;

    public int getPortfolio_id() {
        return portfolio_id;
    }

    public void setPortfolio_id(int portfolio_id) {
        this.portfolio_id = portfolio_id;
    }

    public int getAmount_of_stock_purchased() {
        return amount_of_stock_purchased;
    }

    public void setAmount_of_stock_purchased(int amount_of_stock_purchased) {
        this.amount_of_stock_purchased = amount_of_stock_purchased;
    }

    public float getSingle_stock_purchased_price() {
        return single_stock_purchased_price;
    }

    public void setSingle_stock_purchased_price(float single_stock_purchased_price) {
        this.single_stock_purchased_price = single_stock_purchased_price;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolio_id=" + portfolio_id +
                ", amount_of_stock_purchased=" + amount_of_stock_purchased +
                ", single_stock_purchased_price=" + single_stock_purchased_price +
                '}';
    }
}
