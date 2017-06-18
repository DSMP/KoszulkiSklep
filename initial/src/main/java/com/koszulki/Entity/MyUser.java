package com.koszulki.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
public class MyUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // zmienic na identity
    @Column(name = "user_id")
    private Integer id;
    private String name;
    private String surname;
    private String email;
    @NotEmpty(message = "*Please provide your password")
    private String password;
    private Integer Active;
    private long Number;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<MyUserRole> Roles;

    public MyUser(){}

    MyUser(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<MyUserRole> getRoles() {
        return Roles;
    }

    public void setRoles(Set<MyUserRole> roles) {
        Roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return Active;
    }

    public void setActive(Integer active) {
        Active = active;
    }

    public long getNumber() {
        return Number;
    }

    public void setNumber(long number) {
        Number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
