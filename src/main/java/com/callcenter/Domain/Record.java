package com.callcenter.Domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrecord", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "clockin", nullable = false, length = 45)
    private String clockin;

    @Column(name = "clockout", nullable = true, length = 45)
    private String clockout;


    @ManyToOne
    @JoinColumn(name = "iduser")
    private User iduser;

    @Override
    public String toString() {
        return "Record(id=" + this.getId() + ", date=" + this.getDate() + ", clockin=" + this.getClockin() + ", clockout=" + this.getClockout();
    }
}