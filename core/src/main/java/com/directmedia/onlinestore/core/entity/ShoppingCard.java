/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.directmedia.onlinestore.core.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author patrickfrank
 */
public class ShoppingCard {
    
    public Set<Work> items;
    
    public ShoppingCard(){
        items = new HashSet();
    }
    
}
