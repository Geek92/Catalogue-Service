/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.directmedia.onlinestore.exception;

/**
 *
 * @author patrickfrank
 */
public class DuplicateWorkException extends Exception {
    
    public DuplicateWorkException(){
        super("cette oeuvre a deja ete ajoutée au catalogue");
    }
}
