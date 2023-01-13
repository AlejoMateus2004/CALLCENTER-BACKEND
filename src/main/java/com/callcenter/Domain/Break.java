package com.callcenter.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "breaks")
public class Break {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbreaks", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idrecord", nullable = false)
    private Record idrecord;

    @Column(name = "clockin", nullable = false, length = 45)
    private String clockin;

    @Column(name = "clockout", nullable = true, length = 45)
    private String clockout;



}