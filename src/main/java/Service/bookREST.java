/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DomainLayer.Controller;
import DomainLayer.author;
import DomainLayer.book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author mustafahakimi
 */
@Path("book")
public class bookREST {

    @Context
    private UriInfo context;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Controller c = new Controller();

    /**
     * Creates a new instance of bookREST
     */
    public bookREST() {
    }
    
    
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public String getBook(@PathParam("id") String id) {
        return gson.toJson(c.getBook(id));
    }
    
    @GET
    @Produces("application/json")
    public String getAllBooks(){
        Collection<book> books = c.getAllBooks();
        JsonArray json = new JsonArray();
        for(book b : books){
            JsonObject jo = new JsonObject();
            jo.addProperty("UID", b.getUID());
            jo.addProperty("title", b.getTitle());
            jo.addProperty("text", b.getText());
            json.add(jo);
        }
        String jsonStr = gson.toJson(json);
        return jsonStr;
    }

}
