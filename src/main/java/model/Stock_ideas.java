package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock_ideas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stock_ideas_list_id;
    private String name;

    public int getStock_ideas_list_id() {
        return stock_ideas_list_id;
    }

    public void setStock_ideas_list_id(int stock_ideas_list_id) {
        this.stock_ideas_list_id = stock_ideas_list_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stock_ideas{" +
                "stock_ideas_list_id=" + stock_ideas_list_id +
                ", name='" + name + '\'' +
                '}';
    }
}
