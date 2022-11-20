/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.directmedia.onlinestore.services.ressources;

//import com.directmedia.onlinestore.backoffice.interfaces.Editable;
//import com.directmedia.onlinestore.backoffice.interfacesImpl.EditableImpl;
import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.util.HashSet;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author patrickfrank
 */
@Path("/ressources")
public class WorkRessources {
 
 /**
  * cette methode nous permets d'obtenir la liste des oeuvres presentes dans le catalogue
  * @return SET<Work>
  */
 @GET
 @Produces(MediaType.APPLICATION_JSON)  
    public HashSet<Work> liste(){
    
         //si le catalogue est vide je cree les ouvres et je les ajoutes au catalogue
            if(Catalogue.listOfWorks.isEmpty()){
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
                work3.setTitle("la loi du talion");
                Artist patrick = new Artist("Patrick");
                work3.setMainArtist(patrick);
                work3.setRelease(2008);
                work3.setType("RAP");
                
                Catalogue.listOfWorks.add(work1);
                Catalogue.listOfWorks.add(work2);
                Catalogue.listOfWorks.add(work3);
            }
            
            return Catalogue.listOfWorks;
    }
/**
 * cette methode nous permets de retrouver une oeuvre dans le catalogue a partir de son identifiant
 * @param id
 * @return Work
 */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Work getWorkById(@QueryParam("id") int id){
        Work work = null;
        for(Work w: Catalogue.listOfWorks){
            if(w.getId() == id){
                work = w;
                break;
            }
        }
        return work;
    }
  
    /**
     * cette methode nous permets d'ajouter une nouvelle oeuvre dans le catalogue
     * @param title
     * @param release
     * @param type
     * @param summary
     * @param Artist
     * @return Response CREATED(code 201)
     */
    @POST
    public Response addWork(@FormParam("title") String title,@FormParam("release") int release,@FormParam("type") String type,
            @FormParam("summary") String summary,@FormParam("Artist") String Artist){
        
        Work newWork = new Work();
        newWork.setTitle(title);
        newWork.setRelease(release);
        newWork.setSummary(summary);
        newWork.setType(type);
        Artist artist = new Artist(Artist);
        newWork.setMainArtist(artist);
        Catalogue.listOfWorks.add(newWork);
        
        return Response.status(Response.Status.CREATED).entity(newWork.getId()).build();
        
    }
    
    /**
     * cette methode nous permets de modifier le titre d'une oeuvre presente dans le catalogue
     * @param id
     * @param title
     * @return Response OK(code 200) ou NOT FOUND(code 404)
     */
    @PUT
    @Path("{id}/{title}")
    public Response changeTitle(@QueryParam("id")int id, @QueryParam("title") String title){
       
        boolean result = false;
        for(Work work: Catalogue.listOfWorks){
            if(work.getId()== id){
                work.setTitle(title);
                result = true;
                break;
            }
        }
        if(result){
                return Response.status(Response.Status.OK).build();
        } else{
                return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    /**
     * cette methode nous permets de supprimer un article du catalogue
     * @param id
     * @return Response OK(code 200) ou NOT FOUND(code 404)
     */
    @DELETE
    @Path("/{id}")
    public Response deleteWork(@QueryParam("id") int id){
        boolean result;        
        Work work = null;
        for(Work w : Catalogue.listOfWorks){
            if(w.getId() == id){
                work = w;
                break;
            }
        }
        result = Catalogue.listOfWorks.remove(work);
        if(result){
                return Response.status(Response.Status.OK).build();
        } else{
                return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
