/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.directmedia.onlinestore.core;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author patrickfrank
 */
public class Core {

    public static void main(String[] args) {
        
        // je cree les trois musiques a ajouter au catalogue
        //<a href="https://openclassrooms.com">OpenClassrooms</a>
        Work work1 = new Work();
        work1.setTitle("banlieusard");
        Artist kerry = new Artist("Kerry James");
        work1.setMainArtist(kerry);
        work1.setRelease(2004);
        work1.setType("RAP");
        
        Work work2 = new Work();
        work2.setTitle("la symphonie des chargeurs");
        Artist fababy = new Artist("Fababy");
        work2.setMainArtist(fababy);
        work2.setRelease(2008);
        work2.setType("RAP");
        
        Work work3 = new Work();
        work3.setTitle("l'effet papillon");
        Artist youssoupha = new Artist("Youssoupha");
        work3.setMainArtist(youssoupha);
        work3.setRelease(2011);
        work3.setType("RAP");
        
        // je recupere mon catalogue et j'ajoute les musiques crees au paravant
       //Catalogue.listOfWorks = new HashSet();
        Catalogue.listOfWorks.add(work1);
        Catalogue.listOfWorks.add(work2);
        Catalogue.listOfWorks.add(work3); 
        
        for (Work work : Catalogue.listOfWorks) {
            System.out.println(work.getTitle()+"("+work.getRelease()+")");
        }
    }
}
