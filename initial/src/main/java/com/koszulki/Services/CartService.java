package com.koszulki.Services;

import com.koszulki.Entity.CartItem;
import com.koszulki.Entity.GrafphicThing;
import com.koszulki.Entity.MyOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Service
public class CartService {
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
//        if (orderList.isEmpty())
//        {
//            orderList.add(newThing);
//        }
//        else
//        {
//            for (CartItem item : orderList) {
//                if (item.getId() == (newThing.getId()))
//                {
//                    item.increaseQuantity();
//                }
//                else
//                {
//                    orderList.add(newThing);
//                }
//            }
//        }
        orderList.add(newThing);
        return orderList;
    }
}
