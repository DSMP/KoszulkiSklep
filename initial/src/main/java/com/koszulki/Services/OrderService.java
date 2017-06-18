package com.koszulki.Services;

import com.koszulki.DAO.IOrderRepository;
import com.koszulki.Entity.MyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addOrders(List<MyOrder> orders) {
        for (MyOrder order: orders) {
            orderRepository.save(order);
        }
    }
    public Page<MyOrder> getPageOrder(int page) {
        Pageable pageRequest = new PageRequest(page,6);
        return orderRepository.findAll(pageRequest);
    }
}
