package com.koszulki.DAO;

import com.koszulki.Entity.MyUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Damian on 17.05.2017.
 */

public interface IUserRepository extends CrudRepository<MyUser, Integer> {
}
