package com.koszulki.Entity;


import javax.persistence.*;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class GrafphicThing
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    String Name;
    Byte[] Picture;

}

