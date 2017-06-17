package com.koszulki.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Entity
public class MyOrder {

    @Id
    int id;
    @ManyToOne
    GrafphicThing grafphicThings;
    MyUser CustomerOrdered;
    Date dateCreated;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GrafphicThing getGrafphicThings() {
        return grafphicThings;
    }

    public void setGrafphicThings(GrafphicThing grafphicThings) {
        this.grafphicThings = grafphicThings;
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
}
