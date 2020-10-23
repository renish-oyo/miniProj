package com.example.miniproject.models.entity;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

}
