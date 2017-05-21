package com.koszulki.Services;

import com.koszulki.DAO.IUserRepository;
import com.koszulki.Entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 17.05.2017.
 */
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

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
}
