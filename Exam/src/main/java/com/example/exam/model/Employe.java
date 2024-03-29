package com.example.exam.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")

    private String name ;
    @Column(name = "email")

    private String email ;

    @ManyToMany
    @JoinTable(name = "charge",
            joinColumns = @JoinColumn(name = "employe_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();



    @OneToMany(mappedBy = "employe" , cascade = CascadeType.PERSIST)
    private List<Charge> charges;


    public Employe() {
    }

    public Employe(long id, String name, String email, List<String> skills, Set<Project> projects
    ) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.projects
                = projects
        ;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public Set<Project> getCours() {
        return projects
                ;
    }

    public void setCours(Set<Project> projects
    ) {
        this.projects
                = projects
        ;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", projects" +
                "=" + projects
                +
                '}';
    }
}
