package com.koszulki.Entity;

import javax.persistence.Id;


/**
 * Created by Damian on 09.05.2017.
 */

public class GrafphicThing {

    @Id
    int Id;
    String Name;
    Byte[] Photo;

}
