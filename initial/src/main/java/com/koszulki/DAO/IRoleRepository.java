package com.koszulki.DAO;

import com.koszulki.Entity.MyUserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Damian on 29.05.2017.
 */
public interface IRoleRepository extends CrudRepository<MyUserRole,Integer> {
    MyUserRole findByRole(String role);
}
