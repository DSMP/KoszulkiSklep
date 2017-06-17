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


}
