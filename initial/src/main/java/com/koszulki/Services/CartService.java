package com.koszulki.Services;

import com.koszulki.Entity.GrafphicThing;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 17.06.2017.
 */
@Service
public class CartService {
    public void searchAndDeleteGrafphicThing(List<GrafphicThing> grafphicThings, int id)
    {
        for (int i = 0; i < grafphicThings.size(); i++) {
            if (grafphicThings.get(i).getId() == id)
            {
                grafphicThings.remove(i);
            }
        }
    }
}
