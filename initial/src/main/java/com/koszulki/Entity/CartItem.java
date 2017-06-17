package com.koszulki.Entity;

/**
 * Created by Damian on 17.06.2017.
 */
public class CartItem extends GrafphicThing{
    private long quantity = 1;

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
}
