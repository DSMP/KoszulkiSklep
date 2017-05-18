package com.koszulki.Services;

import com.koszulki.Entity.User;
import com.koszulki.DAO.IUserRepository;
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

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(int id)
    {
        return userRepository.findOne(id);
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }
}
