package com.koszulki.DAO;

import com.koszulki.Entity.MyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Damian on 17.05.2017.
 */

public interface IUserRepository extends PagingAndSortingRepository<MyUser, Integer> {
    MyUser findByEmail(String email);
    Page<MyUser> findAllByOrderByIdAsc(Pageable pageable);

}
