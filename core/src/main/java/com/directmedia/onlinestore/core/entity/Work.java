/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.directmedia.onlinestore.core.entity;

/**
 *
 * @author patrickfrank
 */
public class Work {
    
    private String title;
    private String type;
    private int release;
    private String summary;
    private Artist mainArtist;
    private int id;
    public static int lastId;
    
    public Work(){
        //je definie l'id de l'oeuvre crée en fonction de l'id de l'ouvre precedente 
        //et je memorise la valeur de l'ouvre actuelle dans ma variable lastId;
        id = lastId ++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getTitle() {
        return title;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Artist getMainArtist() {
        return mainArtist;
    }

    public void setMainArtist(Artist mainArtist) {
        this.mainArtist = mainArtist;
    }

    /**
     *
     * @param o the object to compare with the actual one
     * @return boolean 
     */
    @Override
    public boolean equals(Object o) {
         Work secondWork = (Work)o;
         return(this.id == secondWork.getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        return hash;
    }
    
}
