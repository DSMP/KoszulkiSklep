package com.koszulki.DAO;

import com.koszulki.Entity.Koszulka;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Damian on 17.05.2017.
 */
@Transactional
public interface IKoszulkaRepository extends IGrafphicThingRepository<Koszulka>{

}
