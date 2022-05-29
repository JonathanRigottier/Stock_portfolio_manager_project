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

}
