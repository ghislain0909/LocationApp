/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.restControllers;

import com.location.entities.Maison;
import com.location.entities.Quartier;
import com.location.entities.Ville;
import com.location.service.FileStorageService;
import com.location.service.MetierService;
import com.location.web.PostMaison;
import com.location.web.PostQuartier;
import com.location.web.PostVille;
import com.location.web.UploadFileResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.http.RequestEntity.method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author archie
 */
@RestController
public class MetierController  {
    
    private static final Logger logger = LoggerFactory.getLogger(MetierController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private MetierService metierService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    @RequestMapping(value ="/maisons/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("formData") MultipartFile[] files) {
        logger.debug("Multiple file upload!");
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/maisons")
    public List<Maison> getAllMaisons() {
        return metierService.getAllMaisons();
    }
    
  
    @PostMapping("/maisons")
    public Maison addMaison(@RequestBody PostMaison post) {
        Maison maison = new Maison();
        maison .setTitre(post.getTitre());
        maison.setPrix(post.getPrix());
        maison.setPeriode(post.getPeriode());
        maison.setCaution(post.getCaution());
        maison.setLongitude(post.getLongitude());
        maison.setLatitude(post.getLatitude());
        maison.setNbPieces(post.getNbPieces());
        maison.setEau(post.isEau());
        maison.setElectrique(post.isElectrique());
        maison.setCuisineInterne(post.isCuisineInterne());
        maison.setTypeBien(post.getTypeBien());
        maison.setTypeCour(post.getTypeBien());
        System.out.println(maison);
        return maison;
    }

    @PutMapping("/maisons/{id}")
    public Maison updateMaison(Long id, PostMaison post) {
        Maison maison = new Maison();
        maison .setTitre(post.getTitre());
        maison.setPrix(post.getPrix());
        maison.setPeriode(post.getPeriode());
        maison.setCaution(post.getCaution());
        maison.setLongitude(post.getLongitude());
        maison.setLatitude(post.getLatitude());
        maison.setNbPieces(post.getNbPieces());
        maison.setEau(post.isEau());
        maison.setElectrique(post.isElectrique());
        maison.setCuisineInterne(post.isCuisineInterne());
        maison.setTypeBien(post.getTypeBien());
        maison.setTypeCour(post.getTypeBien());
        maison.setQuartier(this.getOneQuartier(post.getIdQuartier()));
        maison.setVille(this.getOneVille(post.getIdVille()));
        return metierService.updateMaison(id, maison);
    }

    @GetMapping("/maisons/{id}")
    public Maison getOneMaison(@PathParam("id") Long id) {
        return metierService.getOneMaison(id);
    }

    public void deleteMaison(Maison maison) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping("/quartiers")
    public List<Quartier> getAllQuartiers() {
        return metierService.getAllQuartiers();
    }

    @PostMapping("/quartiers")
    public Quartier addQuartier(@RequestBody PostQuartier post) {
        Quartier quartier = new Quartier();
        quartier.setNomQuartier(post.getNomQuartier());
        quartier.setVille(this.getOneVille(post.getIdVille()));
        return metierService.addQuartier(quartier);
    }

    public Quartier updateQuartier(Long id, Quartier quartier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping("/quartiers/{id}")
    public Quartier getOneQuartier(@PathVariable("id") Long id) {
        return metierService.getOneQuartier(id);
    }

    public void deleteQuartier(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping("/villes")
    public List<Ville> getAllVilles() {
        return metierService.getAllVilles();
    }

    @PostMapping("/villes")
    public Ville addVille(@RequestBody PostVille post) {
        Ville ville = new Ville();
        ville.setNomVille(post.getNomVille());
        ville.setPays(post.getPays());
        return metierService.addVille(ville);
    }

    
    public Ville updateVille(Long id, Ville ville) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping("/villes/{id}")
    public Ville getOneVille(@PathVariable("id") Long id) {
        return metierService.getOneVille(id);
    }
    
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
        }
    }

}
