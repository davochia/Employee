package com.wisekingdavid.loggable.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private int age;
    private String email;
    private int phone;

}
