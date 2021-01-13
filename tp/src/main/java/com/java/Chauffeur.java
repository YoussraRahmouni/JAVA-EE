package com.java;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chauf")
public class Chauffeur {

    @Id
    @Column(name = "chauf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Chauffeur_Voiture",
            joinColumns = { @JoinColumn(name = "C_id") },
            inverseJoinColumns = { @JoinColumn(name = "V_id") }
    )
    private Set<Voiture> voitureSet = new HashSet<>();

    public Chauffeur() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Set<Voiture> getVoitureSet() {
        return voitureSet;
    }
    public void setVoitureSet(Set<Voiture> voitureSet) {
        this.voitureSet = voitureSet;
    }
}
