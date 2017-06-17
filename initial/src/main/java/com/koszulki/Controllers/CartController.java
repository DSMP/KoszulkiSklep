package com.koszulki.Controllers;

import com.koszulki.Entity.CartItem;
import com.koszulki.Entity.MyOrder;
import com.koszulki.Entity.MyUser;
import com.koszulki.Services.CartService;
import com.koszulki.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showYourCart(Model model, HttpSession httpSession)
    {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        model.addAttribute("cartItems", cartItems);
        return "your-cart";
    }
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView removeItemFromCart(Model model, HttpSession httpSession, int id)
    {

        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        cartService.searchAndDeleteItem(cartItems,id);
        return new ModelAndView("redirect:/cart");
    }
    @RequestMapping(value = "/changeQuantity", method = RequestMethod.POST)
    public ModelAndView changeQuantity(HttpSession httpSession, int id, int quantity)
    {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        cartService.changeItemQuantityByItemId(cartItems, id, quantity);
        httpSession.setAttribute("cartItems", cartItems);
        return new ModelAndView("redirect:/cart");
    }
    @RequestMapping(value = "deliveryForm", method = RequestMethod.POST)
    public ModelAndView SendToServerItems(HttpSession httpSession, String adress)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        orderService.addOrders(cartService.ToOrder((List<CartItem>) httpSession.getAttribute("cartItems"),adress, ((User)auth.getPrincipal()).getUsername()));
        return new ModelAndView("redirect:/koszulki");
    }
}
