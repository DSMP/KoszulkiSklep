package com.koszulki.Services;

import com.koszulki.DAO.IRoleRepository;
import com.koszulki.DAO.IUserRepository;
import com.koszulki.Entity.MyUser;
import com.koszulki.Entity.MyUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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


    public MyUser findUserByEmail(String email) {
        List<MyUser> MyUsers = (List<MyUser>) userRepository.findAll();
        for (int i = 0; i < MyUsers.size(); i++) {
            if (MyUsers.get(i).getEmail().equals(email))
                return MyUsers.get(i);
        }
        return null;
    }
    public void register(MyUser user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        List<MyUserRole> MyUserRole = (List<com.koszulki.Entity.MyUserRole>) roleRepository.findAll();
        MyUserRole userRole = null;
        for (int i = 0; i < MyUserRole.size(); i++) {
            if (MyUserRole.get(i).getRole().equals("USER"))
                userRole = MyUserRole.get(i);
        }
        user.setRoles(new HashSet<MyUserRole>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
    public void registerAdmin(MyUser admin)
    {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        List<MyUserRole> MyUserRole = (List<com.koszulki.Entity.MyUserRole>) roleRepository.findAll();
        admin.setActive(1);
        MyUserRole userRole = null;
        for (int i = 0; i < MyUserRole.size(); i++) {
            if (MyUserRole.get(i).getRole().equals("ADMIN"))
                userRole = MyUserRole.get(i);
        }
        admin.setRoles(new HashSet<MyUserRole>(Arrays.asList(userRole)));
        userRepository.save(admin);
    }

    public Page<MyUser> getAllUsers(int pagei) {
        Pageable pageRequest = new PageRequest(pagei,6);
        return userRepository.findAllByOrderByIdAsc(pageRequest);
    }

    public void removeUser(Integer id) {
        userRepository.delete(id);
    }

    public void editTshirt(int id, String name, String surname, String email, String password) {

    }
}
