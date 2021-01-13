package com.java;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "marque")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @OneToMany(mappedBy = "marque", cascade = CascadeType.ALL)
    private Set<Voiture> voitures = new HashSet<>();

    public Marque() {
    }

    public Marque(long id, String nom, Set<Voiture> vs) {
        this.nom = nom;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Voiture> getVs() {
        return voitures;
    }

    public void setVs(Set<Voiture> voitures) {
        this.voitures = voitures;
    }
}
