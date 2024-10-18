package com.restapi.api.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class User {

    //properties
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private String Name;
    private String LastName;
    private String Email;
    private String PassWord;
    // private String Rol;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Tarjeta tarjeta;

    @OneToMany(mappedBy = "userFavs", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonManagedReference  
    private List<Favorites> favorites;

    @ManyToMany(mappedBy = "userRoles")
    // @JsonBackReference  
   // @JsonManagedReference
    private List<Roles> roles;


    ///getter and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassWord() {
        return PassWord;
    }
    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    public Tarjeta getTarjeta() {
       return this.tarjeta;
    }
    public List<Favorites> getFavorites() {
        return this.favorites;
    }
    public void setFavorites(List<Favorites> listFavs) {
        this.favorites = listFavs;
    }
    public List<Roles> getRoles() {
        return roles;
    }
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
