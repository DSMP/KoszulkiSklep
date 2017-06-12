package com.koszulki.Services;

import com.koszulki.DAO.IOtherRepository;
import com.koszulki.Entity.Koszulka;
import com.koszulki.Entity.Other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 12.06.2017.
 */
@Service
public class OtherService {

    @Autowired
    private IOtherRepository otherRepository;

    public List<Other> getAllOthers() {
        return (List<Other>) otherRepository.findAll();
    }

    public void addOther(Other o)
    {
        otherRepository.save(o);
    }

    public void removeOther(Integer id) {
        otherRepository.delete(id);
    }
}
