package com.it.agency.beans;

import com.it.agency.outils.Other;

import javax.persistence.*;

@Entity
@Table(name = "t_recrut", schema = Other.DATEBASE_NAME)
public class Recrut {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_recrut")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "societe")
    private String societe;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "poste")
    private String poste;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Recrut() {
    }

    public Recrut(String societe, String nom, String prenom, String poste, String phone, String email) {
        this.societe = societe;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.phone = phone;
        this.email = email;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Recrut{" +
                "id=" + id +
                ", societe='" + societe + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", poste='" + poste + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
