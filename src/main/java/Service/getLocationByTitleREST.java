/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DomainLayer.Controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("getlocationbytitle")
public class getLocationByTitleREST {

    @Context
    private UriInfo context;
    Controller c = new Controller();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public getLocationByTitleREST() {
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{title}")
    public String getLocationByTitle(@PathParam("title") String title) {
        return gson.toJson(c.getAllLocationByBookTitle(title));
    }
    
}
