package com.koszulki.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Damian on 17.06.2017.
 */
@Entity
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    GrafphicThing grafphicThing;
    @ManyToOne
    MyUser customerOrdered;
    Date dateCreated;
    long quantity;
    boolean isDone = false;
    boolean isCanceled = false;
    String adres;

    public MyOrder() {
    }

    public MyOrder(GrafphicThing grafphicThing) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GrafphicThing getGrafphicThing() {
        return grafphicThing;
    }

    public void setGrafphicThing(GrafphicThing grafphicThing) {
        this.grafphicThing = grafphicThing;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public MyUser getCustomerOrdered() {
        return customerOrdered;
    }

    public void setCustomerOrdered(MyUser customerOrdered) {
        this.customerOrdered = customerOrdered;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
