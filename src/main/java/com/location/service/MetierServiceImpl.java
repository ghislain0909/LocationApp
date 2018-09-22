/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.service;

import com.location.entities.Maison;
import com.location.entities.Quartier;
import com.location.entities.Ville;
import com.location.repositories.MaisonRepository;
import com.location.repositories.QuartierRepository;
import com.location.repositories.VilleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

/**
 *
 * @author archie
 */
@Service("metier")
public class MetierServiceImpl implements MetierService{
    
    @Autowired
    private QuartierRepository quartierRepository;
    @Autowired
    private MaisonRepository maisonRepository;
    @Autowired
    private VilleRepository villeRepository;

    @Override
    public List<Maison> getAllMaisons() {
        return Lists.newArrayList(maisonRepository.findAll());
    }

    @Override
    public Maison addMaison(Maison maison) {
        return maisonRepository.save(maison);
    }

    @Override
    public Maison updateMaison(Long id, Maison maison) {
        maison.setId(id);
        return maisonRepository.save(maison);
    }

    @Override
    public Maison getOneMaison(Long id) {
        return maisonRepository.findById(id).get();
    }

    @Override
    public void deleteMaison(Maison maison) {
        maisonRepository.delete(maison);
    }

    @Override
    public List<Quartier> getAllQuartiers() {
        return Lists.newArrayList(quartierRepository.findAll());
    }

    @Override
    public Quartier addQuartier(Quartier quartier) {
        return quartierRepository.save(quartier);
    }

    @Override
    public Quartier updateQuartier(Long id, Quartier quartier) {
        quartier.setId(id);
        return quartierRepository.save(quartier);
    }

    @Override
    public Quartier getOneQuartier(Long id) {
        return quartierRepository.findById(id).get();
    }

    @Override
    public void deleteQuartier(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ville> getAllVilles() {
        return Lists.newArrayList(villeRepository.findAll());
    }

    @Override
    public Ville addVille(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public Ville updateVille(Long id, Ville ville) {
        ville.setId(id);
        return villeRepository.save(ville);
    }

    @Override
    public Ville getOneVille(Long id) {
        return villeRepository.findById(id).get();
    }
    
}
