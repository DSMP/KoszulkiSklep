package com.koszulki.DAO;

import com.koszulki.Entity.Koszulka;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Damian on 17.05.2017.
 */
public interface IKoszulkaRepository extends CrudRepository<Koszulka,Integer> {
}
