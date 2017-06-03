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

/**
 * Created by Damian on 03.06.2017.
 */
@Controller
public class KoszulkiController {
    @Autowired
    private KoszulkiService koszulkiService;

    @RequestMapping(value = "/koszulki", method = RequestMethod.GET)
    public String blog(Model uiModel, Pageable pageable) {
        PageWrapper<Koszulka> page = new PageWrapper<Koszulka>
        (koszulkiService.getAllkoszulki(pageable), "/koszulki");
        uiModel.addAttribute("page", page);
        return "koszulki";
    }

}
