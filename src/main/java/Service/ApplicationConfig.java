/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * 
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Service.authorREST.class);
        resources.add(Service.bookREST.class);
        resources.add(Service.getBookByAuthorREST.class);
        resources.add(Service.getBookByCityREST.class);
        resources.add(Service.getBookByGeolocationREST.class);
        resources.add(Service.getLocationByTitleREST.class);
        resources.add(Service.locationREST.class);
    }
    
}
