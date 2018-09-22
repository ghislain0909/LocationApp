/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.service;

import com.location.entities.AppRole;
import com.location.entities.AppUser;
import com.location.repositories.AppRoleRepository;
import com.location.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author archie
 */
@Service("account")
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private AppRoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        String hashPasswd = bcryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPasswd);
        userRepository.save(user);
        return user;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        AppRole role = roleRepository.findByRole(roleName);
        AppUser user = userRepository.findByEmail(email);
        System.out.println(user.getEmail() + " " + role.getRole());
        
        user.getRoles(). add(role);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        	return userRepository.findByEmail(email);
    }

    @Override
    public AppUser updatePassword(String email, String password) {
        String pass = bcryptPasswordEncoder.encode(password);
        return userRepository.updatePassword(email, pass);
    }

    @Override
    public AppUser updateUser(String nom, String prenom, String telephone, String email) {
        return userRepository.updateUser(nom, prenom, telephone, email);
    }

    @Override
    public AppUser findUserById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
