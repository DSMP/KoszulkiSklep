package com.koszulki.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
public class Koszulka extends GrafphicThing {

    int size;

    public Koszulka() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
