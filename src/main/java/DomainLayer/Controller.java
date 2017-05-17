/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer;

import DataAccess.DBfacade;
import java.util.Collection;

/**
 *
 * @author mustafahakimi
 */
public class Controller {

    private DBfacade dbf;

    public Controller() {
        dbf = DBfacade.getInstance();
    }

    public Controller(DBfacade dbf) {
        this.dbf = dbf;
    }

    public author getAuthor(String UID) {
        return dbf.getAuthor(UID);
    }

    public Collection<author> getAllAuthors() {
        return dbf.getAllAuthors();
    }

    public location getLocation(String UID) {
        return dbf.getLocation(UID);
    }

    public Collection<location> getAllLocations() {
        return dbf.getAllLocations();
    }

    public book getBook(String UID) {
        return dbf.getBook(UID);
    }

    public Collection<book> getAllBooks() {
        return dbf.getAllBooks();
    }
}
