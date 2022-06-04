package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Broker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int broker_id;
    private String name;
    private String country;
    private LocalDate dateOfRegister;

    public Broker() {
        dateOfRegister = LocalDate.now();
    }

    public int getBroker_id() {
        return broker_id;
    }

    public void setBroker_id(int broker_id) {
        this.broker_id = broker_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "broker_id=" + broker_id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", dateOfRegister=" + dateOfRegister +
                '}';
    }
}
