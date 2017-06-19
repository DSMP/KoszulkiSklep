package com.koszulki.Services;

import com.koszulki.DAO.IKoszulkaRepository;
import com.koszulki.Entity.Koszulka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.io.IOException;
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
        Pageable pageRequest = new PageRequest(page,6);
        return koszulkiRepo.findAllByOrderByIdAsc(pageRequest);
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

    public Koszulka getKoszulkaById(int id)
    {
        return koszulkiRepo.findOne(id);
    }

    public void editTshirt(int id, String newName, MultipartFile picture, int size, Integer price) throws IOException {
        Koszulka koszulka = koszulkiRepo.findOne(id);
        if (!newName.equals(""))
            koszulka.setName(newName);
        if (!picture.isEmpty())
            koszulka.setPicture(picture.getBytes());
        if (size != 0)
            koszulka.setSize(size);
        if (price != null)
            koszulka.setPrice(price);
        koszulkiRepo.save(koszulka);
//        koszulkiRepo.updateTshirt(koszulka.getName(),koszulka.getPicture(), koszulka.getSize(),koszulka.getId());
    }
}
