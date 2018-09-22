package com.location.web;

public class RegisterForm {

            private String filename;

    private String email;

    private String nom;

    private String prenom;

    private String telephone;

    private String password;

    private String repassword;
    
    private String role;


    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getRepassword() {
            return repassword;
    }

    public void setRepassword(String repassword) {
            this.repassword = repassword;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RegisterForm() {
    }

    public RegisterForm(String email, String nom, String prenom, String telephone, String password, String repassword) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.password = password;
        this.repassword = repassword;
    }

	
	
	
	
	
}
