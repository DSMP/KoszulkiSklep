package com.koszulki.Entity;

import javax.persistence.*;
/**
 * Created by Damian on 09.05.2017.
 */
@Entity
public class User {

    @Id
    private String Id;
    private String Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
