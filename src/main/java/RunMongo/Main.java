
package RunMongo;

import DataAccess.MongoMapping;


public class Main {
    public static void main(String[] args) {
        
        MongoMapping m = new MongoMapping();
        
        //m.getBooksByCity("London");
        //m.getBooksByAuthor("Victor Appleton");
        //m.getLocationByTitle("Tom Swift Among The Diamond Makers");
        //m.getBooksByAuthor("Victor Appleton");
        //m.getBooksByCity("London");
        m.getLocationByTitle("The Light Princess");
    }
}
