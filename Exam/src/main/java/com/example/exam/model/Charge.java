package com.example.exam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "charge")
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double charge;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cours_id" )
    private Employe employe;



}
