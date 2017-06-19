package com.koszulki.DAO;

import com.koszulki.Entity.GrafphicThing;
import com.koszulki.Entity.Koszulka;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian on 03.06.2017.
 */
@NoRepositoryBean
public interface IGrafphicThingRepository<T extends GrafphicThing> extends PagingAndSortingRepository<T,Integer> {
//    public Page<T> findAll(Pageable pageable); //findByPublishedIsTrueOrderByPublishedTimeDesc
    Page<T> findAllByOrderByIdAsc(Pageable pageable);
    Page<T> findAllByNameContainingOrderByIdAsc(String name, Pageable pageable);
}
