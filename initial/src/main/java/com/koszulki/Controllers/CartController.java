package com.koszulki.Controllers;

import com.koszulki.Entity.GrafphicThing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Controller
public class CartController {
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showYourCart(Model model, HttpSession httpSession)
    {
        List<GrafphicThing> cartItems = (List<GrafphicThing>) httpSession.getAttribute("cartItems");
        model.addAttribute("cartItems", cartItems);
        return "your-cart";
    }
}
