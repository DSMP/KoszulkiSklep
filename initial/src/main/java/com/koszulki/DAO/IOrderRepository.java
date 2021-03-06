package com.koszulki.DAO;

import com.koszulki.Entity.MyOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Damian on 17.06.2017.
 */
@Repository
public interface IOrderRepository extends PagingAndSortingRepository<MyOrder,Integer> {
    Page<MyOrder> findAllByOrderByIdAsc(Pageable pageable);
}
