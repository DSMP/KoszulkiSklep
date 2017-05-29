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

    private String role;

    public MyUserRole() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
