package com.koszulki.Controllers;

import com.koszulki.Entity.Koszulka;
import com.koszulki.Services.KoszulkiService;
import com.koszulki.Utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Damian on 03.06.2017.
 */
@Controller
public class KoszulkiController {
    @Autowired
    private KoszulkiService koszulkiService;

    @RequestMapping(value = "/koszulki", method = RequestMethod.GET)
    public String koszulki(Model uiModel, Pageable pageable) {
        PageWrapper<Koszulka> page = new PageWrapper<Koszulka>
        (koszulkiService.getAllKoszulki(pageable), "/koszulki");
        uiModel.addAttribute("page", page);
        return "koszulki";
    }

    @RequestMapping(value = "/admin/addkoszulka", method = RequestMethod.GET)
    public ModelAndView addKoszulka()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("koszulka", new Koszulka());
        mav.setViewName("admin/addkoszulka");
        return mav;
    }

    @RequestMapping(value = "/admin/addkoszulka", method = RequestMethod.POST)
    public String addKoszulka(@Valid Koszulka koszulka)
    {
        koszulkiService.addKoszulka(koszulka);
        return "admin/hello";
    }

}
