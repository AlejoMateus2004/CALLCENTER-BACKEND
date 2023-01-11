package com.callcenter.Domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "iduser", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "mail", nullable = false, length = 60)
    private String mail;

    @Column(name = "state", nullable = false)
    private boolean state;

    @Column(name = "type_user", nullable = false)
    private boolean typeUser;

    @Column(name = "date_ingress", nullable = false)
    private LocalDate dateIngress;

    @Column(name = "password", nullable = false, length = 200)
    private String password;



}