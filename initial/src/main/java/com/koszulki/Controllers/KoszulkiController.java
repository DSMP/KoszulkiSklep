package com.koszulki.Controllers;

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

import javax.validation.Valid;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

/**
 * Created by Damian on 03.06.2017.
 */
@Controller
public class KoszulkiController {
    @Autowired
    private KoszulkiService koszulkiService;
//    dla userow pageable
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

//    @RequestMapping(value = "/admin/manage-koszulka", method = RequestMethod.GET) // non paging
//    public ModelAndView addKoszulki()
//    {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("koszulki.html", koszulkiService.getAllKoszulki());
//        mav.setViewName("admin/manage-koszulka");
//        return mav;
//    }
    @RequestMapping(value = "/admin/manage-koszulka", method = RequestMethod.GET) //paging
    public String getManageKoszulki(Model uiModel)
    {
        Page<Koszulka> page = koszulkiService.getAllKoszulki(0);
        uiModel.addAttribute("page", page);
        return "admin/manage-koszulka";
    }
    @RequestMapping(value = "/admin/manage-koszulka1", method = RequestMethod.GET) //paging
    public String getManageKoszulki(Model uiModel, @RequestParam Integer pagei)
    {
        Page<Koszulka> page = koszulkiService.getAllKoszulki(pagei);
        uiModel.addAttribute("page", page);
        return "admin/manage-koszulka";
    }

    @RequestMapping(value = "/admin/addkoszulka", method = RequestMethod.POST)
    public ModelAndView addKoszulki(Model uiModel, @RequestParam String name, @RequestParam MultipartFile picture, @RequestParam Integer size) throws IOException {
        Koszulka koszulka= new Koszulka();
        koszulka.setName(name); koszulka.setPicture(picture.getBytes()); koszulka.setSize(size);
        koszulkiService.addKoszulka(koszulka);
        return new ModelAndView("redirect:/admin/manage-koszulka");
    }
//    @RequestMapping(value = "image/{imageName}")
//    @ResponseBody
//    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
//        File serverFile = new File("/home/user/uploads/" + imageName + ".jpg");
//        return Files.readAllBytes(serverFile.toPath());
//    }
    @RequestMapping(value = "/admin/removekoszulka", method = RequestMethod.POST)
    public ModelAndView removeKoszulka(Model uiModel, @RequestParam Integer id)
    {
        koszulkiService.removeKoszulka(id);
        return new ModelAndView("redirect:/admin/manage-koszulka");
    }

}
