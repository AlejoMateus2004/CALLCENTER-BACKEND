package com.callcenter.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "incident_type")
public class IncidentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idincident_type", nullable = false)
    private Integer id;

    @Column(name = "descripition", nullable = false, length = 45)
    private String descripition;


}