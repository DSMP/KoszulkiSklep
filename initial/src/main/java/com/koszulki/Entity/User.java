package com.koszulki.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Damian on 09.05.2017.
 */
@Entity
public class User {
    @Id
    int Id;
    String Name;
}
