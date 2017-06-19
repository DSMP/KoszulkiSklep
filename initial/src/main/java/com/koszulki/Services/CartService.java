package com.koszulki.Services;

import com.koszulki.Entity.CartItem;
import com.koszulki.Entity.GrafphicThing;
import com.koszulki.Entity.MyOrder;
import com.koszulki.Entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Service
public class CartService {
    @Autowired
    UserService userService;
    public void searchAndDeleteItem(List<CartItem> orderList, int id)
    {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == id)
            {
                orderList.remove(i);
            }
        }
    }
    public List<CartItem> add(List<CartItem> orderList, CartItem newThing)
    {
        if (orderList.isEmpty())
        {
            orderList.add(newThing);
        }
        else
        {
            boolean existOnList = false;
            for (int i=0; i < orderList.size(); i++) {
                if (orderList.get(i).getId() == (newThing.getId()))
                {
                    orderList.get(i).increaseQuantity();
                    existOnList = true;
                }
            }
            if (!existOnList)
            {
                orderList.add(newThing);
            }
        }
        return orderList;
    }
    public void changeItemQuantityByItemId(List<CartItem> orderList, int id, int quantity)
    {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == id)
            {
                orderList.get(i).setQuantity(quantity);
            }
        }
    }

    public List<MyOrder> ToOrder(List<CartItem> orderList, String adress, String emailUserLogged)
    {
        List<MyOrder> dbOrderList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            MyOrder order = new MyOrder();
            order.setQuantity(orderList.get(i).getQuantity());
            order.setGrafphicThing(orderList.get(i).getGrafphicThing());
            order.setDateCreated(new Date());
            order.setDone(false);
            order.setAdres(adress);
            order.setCustomerOrdered(userService.findUserByEmail(emailUserLogged));
            dbOrderList.add(order);
        }
        return dbOrderList;
    }

    public float getSumPrice(List<CartItem> cartItems) {
        if (cartItems == null || cartItems.isEmpty()) return 0;
        float sum = 0;
        for (CartItem item : cartItems) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }
}
