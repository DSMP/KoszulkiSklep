package com.koszulki.Controllers.AdminControllers;

import com.koszulki.Entity.MyUser;
import com.koszulki.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Damian on 19.06.2017.
 */
@Controller
@RequestMapping("/admin/manage-users")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET) //paging
    public String getManageKoszulki(Model uiModel)
    {
        Page<MyUser> page = userService.getAllUsers(0);
        uiModel.addAttribute("page", page);
        return "admin/manage-users";
    }
    @RequestMapping(value = "1", method = RequestMethod.GET) //paging
    public String getManageKoszulki(Model uiModel, @RequestParam Integer pagei)
    {
        Page<MyUser> page = userService.getAllUsers(pagei);
        uiModel.addAttribute("page", page);
        return "admin/manage-users";
    }

    @RequestMapping(value = "/addadmin", method = RequestMethod.POST)
    public ModelAndView addKoszulki(Model uiModel, String name, String surname, String email, String password, int number){
        MyUser myUser = new MyUser();
        myUser.setName(name); myUser.setName(surname); myUser.setEmail(email); myUser.setPassword(password); myUser.setNumber(number);
        userService.registerAdmin(myUser);
        return new ModelAndView("redirect:/admin/manage-users");
    }
    @RequestMapping(value = "/removeuser", method = RequestMethod.POST)
    public ModelAndView removeKoszulka(Model uiModel, @RequestParam Integer id)
    {
        userService.removeUser(id);
        return new ModelAndView("redirect:/admin/manage-users");
    }
    @RequestMapping(value = "/edituserkoszulka", method = RequestMethod.POST)
    public ModelAndView editKoszulka(int id, String name, String surname, String email, String password)
    {
        userService.editTshirt(id, name, surname, email, password);

        return new ModelAndView("redirect:/admin/manage-koszulka");
    }
}
