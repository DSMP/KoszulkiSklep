package com.koszulki.DAO;

import com.koszulki.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Damian on 17.05.2017.
 */
@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
}
