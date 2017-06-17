package com.koszulki.Entity;

/**
 * Created by Damian on 17.06.2017.
 */
public class CartItem extends GrafphicThing{
    private long quantity = 1;
    private GrafphicThing grafphicThing; // trzeba by sie zastanowic i dodatkowo metoda getGraf dzieki ktorej nie stracilbym danych na temat konkretnego elementu
    public CartItem() {
    }

    public CartItem(GrafphicThing grafphicThing) {
        super();
        this.setId(grafphicThing.getId());
        this.setName(grafphicThing.getName());
        this.setPicture(grafphicThing.getPicture());
        this.grafphicThing = grafphicThing;
    }

    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public void increaseQuantity()
    {
        this.quantity++;
    }
    public void decreaseQuantity()
    {
        this.quantity--;
    }

    public GrafphicThing getGrafphicThing() {
        return grafphicThing;
    }

    public void setGrafphicThing(GrafphicThing grafphicThing) {
        this.grafphicThing = grafphicThing;
    }
}
