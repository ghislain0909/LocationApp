/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.location.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author archie
 */
public interface FileStorageService {
    
     public String storeFile(MultipartFile file);
     
     public Resource loadFileAsResource(String fileName);
    
}
