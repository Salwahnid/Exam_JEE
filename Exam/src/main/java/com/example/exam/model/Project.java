package com.example.exam.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")

    private String name ;

    @Column(name = "budjet")

    private  double budget;


    @ManyToMany(mappedBy = "projects")
    private Set<Employe> employes = new HashSet<>();


    @OneToMany(mappedBy = "project" , cascade = CascadeType.PERSIST)
    private List<Charge> charges;

    public Project() {
    }

    public Project(long id, String name, double budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
