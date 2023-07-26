package com.example.tigres.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "soigneurs")
public class Soigneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prenom;

    @ManyToMany
    private List<Tigre> tigresAsoigner = new ArrayList<>();

    public void setTigresAsoigner(List<Tigre> tigresAsoigner) {
        this.tigresAsoigner = tigresAsoigner;
    }

    public List<Tigre> getTigresAsoigner() {
        return tigresAsoigner;
    }

    public Soigneur() {
    }

    public Soigneur(String prenom) {
        this.prenom = prenom;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public void addSoignes(Tigre newTigre) {
        tigresAsoigner.add(newTigre);
    }
}
