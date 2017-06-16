package com.koszulki.Services;

import com.koszulki.DAO.IKoszulkaRepository;
import com.koszulki.Entity.Koszulka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 03.06.2017.
 */
@Service
public class KoszulkiService {
    @Autowired
    private IKoszulkaRepository koszulkiRepo;
    public Page<Koszulka> getAllKoszulki(int page)
    {
        Pageable pageRequest = new PageRequest(page,5);
        return koszulkiRepo.findAll(pageRequest);
    }
    public List<Koszulka> getAllKoszulki(){
        return (List<Koszulka>) koszulkiRepo.findAll();
    }

    public void addKoszulka(Koszulka k)
    {
        koszulkiRepo.save(k);
    }

    public void removeKoszulka(Integer id) {
        koszulkiRepo.delete(id);
    }


}
