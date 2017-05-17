/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DomainLayer.Controller;
import DomainLayer.author;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author mustafahakimi
 */
@Path("author")
public class authorREST {

    @Context
    private UriInfo context;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Controller c = new Controller();

    public authorREST() {
    }

    
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public String getAuthor(@PathParam("id") String id) {
        return gson.toJson(c.getAuthor(id));
    }
    
    @GET
    @Produces("application/json")
    public String getAllAuthors(){
        Collection<author> authors = c.getAllAuthors();
        JsonArray json = new JsonArray();
        for(author a : authors){
            JsonObject jo = new JsonObject();
            jo.addProperty("UID", a.getUID());
            jo.addProperty("name", a.getName());
            json.add(jo);
        }
        String jsonStr = gson.toJson(json);
        return jsonStr;
    }
}
