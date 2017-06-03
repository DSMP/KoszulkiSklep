package com.koszulki.DAO;

import com.koszulki.Entity.Naklejka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Damian on 17.05.2017.
 */
@Transactional
public interface INaklejkaRepository extends IGrafphicThingRepository<Naklejka> {
}
