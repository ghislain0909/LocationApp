/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.repositories;

import com.location.entities.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author archie
 */
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    public AppUser findByEmail(String email);
    
    @Query("update AppUser appUser set appUser.password=?2 where appUser.email=?1")
    @Modifying
    public AppUser updatePassword(String email, String password);
    
    @Query("update AppUser appUser set appUser.nom=?1, appUser.prenom=?2, appUser.telephone=?3 where appUser.email=?4")
    public AppUser updateUser(String nom, String prenom, String telephone, String email);

}
