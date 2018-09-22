/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.service;

import com.location.entities.Maison;
import com.location.entities.Quartier;
import com.location.entities.Ville;
import java.util.List;

/**
 *
 * @author archie
 */

public interface MetierService {
    
    public List<Maison> getAllMaisons();
    
    public Maison addMaison(Maison maison);
    
    public Maison updateMaison(Long id, Maison maison);
    
    public Maison getOneMaison(Long id);
    
    public void deleteMaison(Maison maison);
    
    public List<Quartier> getAllQuartiers();
    
    public Quartier addQuartier(Quartier quartier);
    
    public Quartier updateQuartier(Long id, Quartier quartier);
    
    public Quartier getOneQuartier(Long id);
    
    public void deleteQuartier(Long id);
    
    public List<Ville> getAllVilles();
    
    public Ville addVille(Ville ville);
    
    public Ville updateVille(Long id, Ville ville);
    
    public Ville getOneVille(Long id);
    
    
    
}
