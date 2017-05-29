package com.koszulki.Services;

import com.koszulki.DAO.IRoleRepository;
import com.koszulki.DAO.IUserRepository;
import com.koszulki.Entity.MyUser;
import com.koszulki.Entity.MyUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Damian on 17.05.2017.
 */
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;

    public List<MyUser> getAllUsers()
    {
        List<MyUser> myUsers = new ArrayList<>();
        userRepository.findAll().forEach(myUsers::add);
        return myUsers;
    }

    public MyUser getUser(Integer id)
    {
        return userRepository.findOne(id);
    }

    public void addUser(MyUser myUser)
    {
        userRepository.save(myUser);
    }

//    public void register(MyUser user)
//    {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(1);
//        MyUserRole userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<MyUserRole>(Arrays.asList(userRole)));
//        userRepository.save(user);
//    }
}
