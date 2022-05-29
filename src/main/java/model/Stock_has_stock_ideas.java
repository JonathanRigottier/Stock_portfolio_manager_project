package model;

import javax.persistence.*;

@Entity
public class Stock_has_stock_ideas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stock_has_stock_ideas_id;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "stock_ideas_list_id")
    private Stock_ideas stock_ideas;

    public int getStock_has_stock_ideas() {
        return stock_has_stock_ideas_id;
    }

    public void setStock_has_stock_ideas(int stock_has_stock_ideas_id) {
        this.stock_has_stock_ideas_id = stock_has_stock_ideas_id;
    }

    @Override
    public String toString() {
        return "Stock_has_stock_ideas{" +
                "stock_has_stock_ideas=" + stock_has_stock_ideas_id +
                '}';
    }
}
