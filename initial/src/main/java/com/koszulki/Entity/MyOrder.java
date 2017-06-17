package com.koszulki.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Damian on 17.06.2017.
 */
@Entity
public class MyOrder {

    @Id
    int id;
    @ManyToOne
    GrafphicThing grafphicThing;
    MyUser CustomerOrdered;
    Date dateCreated;
    long quantity;

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
        return CustomerOrdered;
    }

    public void setCustomerOrdered(MyUser customerOrdered) {
        CustomerOrdered = customerOrdered;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}
