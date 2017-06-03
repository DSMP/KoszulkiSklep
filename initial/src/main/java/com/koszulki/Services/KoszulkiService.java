package com.koszulki.Services;

import com.koszulki.DAO.IKoszulkaRepository;
import com.koszulki.Entity.Koszulka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 03.06.2017.
 */
@Service
public class KoszulkiService {
    @Autowired
    private IKoszulkaRepository koszulkiRepo;
    public Page<Koszulka> getAllkoszulki(Pageable pagable)
    {
        return koszulkiRepo.getAllByIdOrderByIdAsc(pagable);
    }
}
