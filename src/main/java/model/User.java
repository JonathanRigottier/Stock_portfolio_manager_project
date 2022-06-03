package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String name;
    private String username;
    private String password;
    private float amount_invested;
    private LocalDate dateOfRegister = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "stock_ideas_list_id")
    private Stock_ideas stock_ideas;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "broker_id")
    private Broker broker;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getAmount_invested() {
        return amount_invested;
    }

    public void setAmount_invested(float amount_invested) {
        this.amount_invested = amount_invested;
    }

    public LocalDate getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", amount_invested=" + amount_invested +
                ", dateOfRegister=" + dateOfRegister +
                ", stock_ideas=" + stock_ideas +
                ", portfolio=" + portfolio +
                ", broker=" + broker +
                '}';
    }
}
