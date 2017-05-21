package com.koszulki.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
public class MyUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Name;

    MyUser(){}

    MyUser(Integer id, String name)
    {
        Id = id;
        Name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
