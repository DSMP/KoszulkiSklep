package com.koszulki.Controllers;

import com.koszulki.Entity.CartItem;
import com.koszulki.Entity.Koszulka;
import com.koszulki.Entity.MyOrder;
import com.koszulki.Services.CartService;
import com.koszulki.Services.KoszulkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 03.06.2017.
 */
@Controller
public class KoszulkiController {
    @Autowired
    private KoszulkiService koszulkiService;
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/koszulki", method = RequestMethod.GET)
    public String koszulki(Model uiModel) {
        Page<Koszulka> page = koszulkiService.getAllKoszulki(0);
        uiModel.addAttribute("page", page);
        return "koszulki";
    }
    @RequestMapping(value = "/koszulki1", method = RequestMethod.GET)
    public String koszulki(Model uiModel, int pagei) {
        Page<Koszulka> page = koszulkiService.getAllKoszulki(pagei);
        uiModel.addAttribute("page", page);
        return "koszulki";
    }
    @RequestMapping(value = "/koszulki2", method = RequestMethod.GET)
    public ModelAndView addToCart(HttpSession httpSession, int pagei, int id)
    {
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        if (cartItems == null)
            cartItems = new ArrayList<>();
        Koszulka koszulka = koszulkiService.getKoszulkaById(id);
        CartItem cartItem = new CartItem();
        cartItem.setId(koszulka.getId());
        cartItem.setName(koszulka.getName());
        cartItem.setPicture(koszulka.getPicture());
        cartItems = cartService.add(cartItems,cartItem);
        httpSession.setAttribute("cartItems", cartItems);
        return new ModelAndView("redirect:/koszulki1?pagei="+pagei);
    }
}
