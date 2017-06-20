package com.koszulki.Controllers.AdminControllers;


import com.koszulki.Entity.MyOrder;
import com.koszulki.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Damian on 18.06.2017.
 */
@Controller
@RequestMapping("/admin/manage-orders")
public class AdminOrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.GET) //paging
    public String getManageOrders(Model uiModel)
    {
        Page<MyOrder> page = orderService.getPageOrder(0);
        uiModel.addAttribute("page", page);
        return "admin/manage-orders";
    }
    @RequestMapping(value = "/paging", method = RequestMethod.GET) //paging
    public String getManageOrders(Model uiModel, @RequestParam Integer pagei)
    {
        Page<MyOrder> page = orderService.getPageOrder(pagei);
        uiModel.addAttribute("page", page);
        return "admin/manage-orders";
    }
    @RequestMapping(value = "/checkSent", method = RequestMethod.GET)
    public ModelAndView checkDone(int orderId)
    {
        orderService.checkOrderDone(orderId);
        return new ModelAndView("redirect:/admin/manage-orders");
    }
    @RequestMapping(value = "/checkCanceled", method = RequestMethod.GET)
    public ModelAndView checkCanceled(int orderId)
    {
        orderService.checkOrderCanceled(orderId);
        return new ModelAndView("redirect:/admin/manage-orders");
    }
}

