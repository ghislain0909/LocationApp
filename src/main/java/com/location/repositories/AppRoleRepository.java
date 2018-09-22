/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.repositories;

import com.location.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author archie
 */
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    public AppRole findByRole(String role);
}
