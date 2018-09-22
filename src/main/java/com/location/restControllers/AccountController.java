/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.restControllers;

import com.location.entities.AppUser;
import com.location.service.AccountService;
import com.location.service.ChPassWordForm;
import com.location.web.UpdateUserForm;
import com.location.web.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author archie
 */
@RestController
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm) {
   
        AppUser appuser = accountService.findUserByEmail(userForm.getEmail());
        if (appuser != null) {
            throw new RuntimeException("this user already exists");
        }
        AppUser user = new AppUser();
        user.setNom(userForm.getNom());
        user.setPrenom(userForm.getPrenom());
        user.setTelephone(userForm.getTelephone());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        accountService.saveUser(user);
        accountService.addRoleToUser(userForm.getEmail(), "PROMOTEUR");
        return user;
    }
    
    @PostMapping("changePassword")
    public AppUser updatePassword(ChPassWordForm post) {
        AppUser app = accountService.findUserByEmail(post.getEmail());
        if (app != null) {
            app = accountService.updatePassword(post.getEmail(), post.getPassword());
        }
        return app;
    }
    
    @PostMapping("/users/{id}")
    public AppUser updateUser(@PathVariable Long id, @RequestBody UpdateUserForm post) {
        AppUser app = accountService.findUserByEmail(post.getEmail());
        if (app.equals( accountService.findUserById(id))){
        throw new RuntimeException("Veuillez vous authentifier");
        }
        app.setNom(post.getNom());
        app.setPrenom(post.getPrenom());
        app.setTelephone(post.getTelephone());
       return app;
    }
    
    @GetMapping("/users/{email}")
    public AppUser getUserByEmail(@PathVariable String email) {
        return accountService.findUserByEmail(email);
    }
    
    
}
