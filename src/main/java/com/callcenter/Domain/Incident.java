package com.callcenter.Domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "incidents")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idincidents", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Lob
    @Column(name = "reason", nullable = false)
    private String reason;

    @OneToOne
    @JoinColumn(name = "idincident_type", nullable = false)
    private IncidentType idincidentType;


}