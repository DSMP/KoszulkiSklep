package com.koszulki.DAO;

import com.koszulki.Entity.Koszulka;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Damian on 17.05.2017.
 */
@Transactional
public interface IKoszulkaRepository extends IGrafphicThingRepository<Koszulka>{

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Koszulka k SET k.name = :name, k.picture = :picture, k.size = :sizeT WHERE k.id = :id")
    int updateTshirt(@Param("name") String name, @Param("picture") byte[] picture, @Param("sizeT") int sizeT, @Param("id") Integer id);
}
