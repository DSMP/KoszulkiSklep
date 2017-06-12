package com.koszulki.Controllers;

import com.koszulki.Entity.Koszulka;
import com.koszulki.Entity.Other;
import com.koszulki.Services.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Damian on 05.06.2017.
 */
@Controller
public class OtherController {

    @Autowired
    OtherService otherService;

    @RequestMapping(value = "/admin/manage-other", method = RequestMethod.GET) // non paging
    public ModelAndView getManageOthers()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("others", otherService.getAllOthers());
        mav.setViewName("admin/manage-other");
        return mav;
    }

    @RequestMapping(value = "/admin/addother", method = RequestMethod.POST)
    public String getManageKoszulki(@RequestParam String name, @RequestParam MultipartFile picture) throws IOException {
        Other other= new Other();
        other.setName(name); other.setPicture(picture.getBytes());
        otherService.addOther(other);
        return "admin/manage-other";
    }
    @RequestMapping(value = "/admin/removeother", method = RequestMethod.POST)
    public String removeKoszulka(@RequestParam Integer id)
    {
        otherService.removeOther(id);
        return "admin/manage-other";
    }
}
