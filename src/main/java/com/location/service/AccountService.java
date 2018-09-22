/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.service;

import com.location.entities.AppRole;
import com.location.entities.AppUser;

/**
 *
 * @author archie
 */
public interface AccountService {
    
    public AppUser saveUser(AppUser user);
    
    public AppUser findUserById(Long id);

    public AppRole saveRole(AppRole role);

    public void addRoleToUser(String email, String roleName);

    public AppUser findUserByEmail(String email);
    
    public AppUser updatePassword(String email, String password);
    
    public AppUser updateUser(String nom, String prenom, String telephone, String email);
    
}
