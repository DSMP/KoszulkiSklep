package com.koszulki.Entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Base64;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class GrafphicThing
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String name;
//    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    byte[] picture;
    @Column(nullable = true)
    float price;

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

    public byte[] getPicture() {
        return picture;
    }
    public String getEncodedPicture() {
        return Base64.getEncoder().encodeToString(picture);
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

