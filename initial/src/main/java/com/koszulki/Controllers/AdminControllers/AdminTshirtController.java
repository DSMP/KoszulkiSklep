package com.koszulki.Controllers.AdminControllers;

import com.koszulki.Entity.Koszulka;
import com.koszulki.Services.KoszulkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Damian on 17.06.2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminTshirtController {

    @Autowired
    KoszulkiService koszulkiService;

    @RequestMapping(value = "/manage-koszulka", method = RequestMethod.GET) //paging
    public String getManageKoszulki(Model uiModel)
    {
        Page<Koszulka> page = koszulkiService.getAllKoszulki(0);
        uiModel.addAttribute("page", page);
        return "admin/manage-koszulka";
    }
    @RequestMapping(value = "/manage-koszulka1", method = RequestMethod.GET) //paging
    public String getManageKoszulki(Model uiModel, @RequestParam Integer pagei)
    {
        Page<Koszulka> page = koszulkiService.getAllKoszulki(pagei);
        uiModel.addAttribute("page", page);
        return "admin/manage-koszulka";
    }

    @RequestMapping(value = "/addkoszulka", method = RequestMethod.POST)
    public ModelAndView addKoszulki(Model uiModel, @RequestParam String name, @RequestParam MultipartFile picture, @RequestParam Integer size) throws IOException {
        Koszulka koszulka= new Koszulka();
        koszulka.setName(name); koszulka.setPicture(picture.getBytes()); koszulka.setSize(size);
        koszulkiService.addKoszulka(koszulka);
        return new ModelAndView("redirect:/admin/manage-koszulka");
    }
    @RequestMapping(value = "/removekoszulka", method = RequestMethod.POST)
    public ModelAndView removeKoszulka(Model uiModel, @RequestParam Integer id)
    {
        koszulkiService.removeKoszulka(id);
        return new ModelAndView("redirect:/admin/manage-koszulka");
    }
}
