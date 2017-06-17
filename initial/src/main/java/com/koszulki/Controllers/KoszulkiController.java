package com.koszulki.Controllers;

import com.koszulki.Entity.GrafphicThing;
import com.koszulki.Entity.Koszulka;
import com.koszulki.Services.KoszulkiService;
import com.koszulki.Utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Damian on 03.06.2017.
 */
@Controller
public class KoszulkiController {
    @Autowired
    private KoszulkiService koszulkiService;

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
        List<GrafphicThing> cartItems = (List<GrafphicThing>) httpSession.getAttribute("cartItems");
        if (cartItems == null)
            cartItems = new ArrayList<>();
        cartItems.add(koszulkiService.getKoszulkaById(id));
        httpSession.setAttribute("cartItems", cartItems);
        return new ModelAndView("redirect:/koszulki1?pagei="+pagei);
    }
}
