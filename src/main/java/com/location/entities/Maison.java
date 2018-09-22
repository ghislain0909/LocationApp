/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author archie
 */
@Entity
public class Maison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titre;
    
    private String prix;
    
    private String periode;
    
    private long caution;
    
    private int nbPieces;
    
    private String typeBien;
    
    private String typeCour;
    
    private long latitude;
    
    private long longitude;
    
    private boolean electrique;
    
    private boolean eau;
    
    private boolean cuisineInterne;
    
    private ArrayList<String> imageNames;
    @ManyToOne
    private Quartier quartier;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    private AppUser appUser;

    public Maison() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public long getCaution() {
        return caution;
    }

    public void setCaution(long caution) {
        this.caution = caution;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    public String getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(String typeBien) {
        this.typeBien = typeBien;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public boolean isElectrique() {
        return electrique;
    }

    public void setElectrique(boolean electrique) {
        this.electrique = electrique;
    }

    public boolean isEau() {
        return eau;
    }

    public void setEau(boolean eau) {
        this.eau = eau;
    }


    public boolean isCuisineInterne() {
        return cuisineInterne;
    }

    public void setCuisineInterne(boolean cuisineInterne) {
        this.cuisineInterne = cuisineInterne;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getTypeCour() {
        return typeCour;
    }

    public void setTypeCour(String typeCour) {
        this.typeCour = typeCour;
    }

    public ArrayList<String> getImageNames() {
        return imageNames;
    }

    public void setImageNames(ArrayList<String> imageNames) {
        this.imageNames = imageNames;
    }
    
    

    
}
