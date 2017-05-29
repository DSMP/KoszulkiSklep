package com.koszulki.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
public class MyUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer Id;
    private String Name;
    private String Email;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<MyUserRole> Roles;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Set<MyUserRole> getRoles() {
        return Roles;
    }

    public void setRoles(Set<MyUserRole> roles) {
        Roles = roles;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
