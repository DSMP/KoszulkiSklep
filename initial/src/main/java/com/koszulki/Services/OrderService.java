package com.koszulki.Services;

import com.koszulki.DAO.IOrderRepository;
import com.koszulki.Entity.MyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 17.06.2017.
 */
@Service
public class OrderService {
    @Autowired
    IOrderRepository orderRepository;

    public void addOrder(MyOrder myOrder)
    {
        orderRepository.save(myOrder);
    }
    public MyOrder getOrder(int id)
    {
        return orderRepository.findOne(id);
    }

    public Iterable<MyOrder> getOrders()
    {
        return orderRepository.findAll();
    }
}