package com.koszulki.Controllers;

import com.koszulki.Entity.GrafphicThing;
import com.koszulki.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showYourCart(Model model, HttpSession httpSession)
    {
        List<GrafphicThing> cartItems = (List<GrafphicThing>) httpSession.getAttribute("cartItems");
        model.addAttribute("cartItems", cartItems);
        return "your-cart";
    }
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView removeItemFromCart(Model model, HttpSession httpSession, int id)
    {
        List<GrafphicThing> cartItems = (List<GrafphicThing>) httpSession.getAttribute("cartItems");
        cartService.searchAndDeleteGrafphicThing(cartItems,id);
        return new ModelAndView("redirect:/cart");
    }
}
