/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.web;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author archie
 */
public class PostMaison {
    
    private String titre;
    
    private String prix;
    
    private String periode;
    
    private long caution;
    
    private int nbPieces;
    
    private String typeBien;
    
    private long latitude;
    
    private long longitude;
    
    private boolean electrique;
    
    private boolean eau;
    
    private boolean cuisineInterne;
    
    private String typeCour;
    
    private MultipartFile[] files;
    
    private Long idQuartier;
    
    private Long idVille;
    
    private Long idAppUser;

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

    public Long getIdQuartier() {
        return idQuartier;
    }

    public void setIdQuartier(Long idQuartier) {
        this.idQuartier = idQuartier;
    }

    public Long getIdVille() {
        return idVille;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public Long getIdAppUser() {
        return idAppUser;
    }

    public void setIdAppUser(Long idAppUser) {
        this.idAppUser = idAppUser;
    }

    public String getTypeCour() {
        return typeCour;
    }

    public void setTypeCour(String typeCour) {
        this.typeCour = typeCour;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
    
}
