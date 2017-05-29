package com.koszulki.Entity;

import javax.persistence.*;

/**
 * Created by Damian on 29.05.2017.
 */
@Entity
public class MyUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer Id;

    private String username;

    public MyUserRole() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
