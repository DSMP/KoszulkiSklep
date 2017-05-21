package com.koszulki.Controllers;

import com.koszulki.Entity.MyUser;
import com.koszulki.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Damian on 17.05.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<MyUser> getAllUsers()
    {
        return userService.getAllUsers();
    }

}
