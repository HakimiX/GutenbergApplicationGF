
package DataAccess;

import DTO.DTOAuthorBook;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;



public class MongoMapping {

    
    private MongoDatabase connect = DBconnectorMongo.getDBConnection();
//    public MongoMapping(){
//        connect = new DBconnectorMongo();
//        connect.initiate();
//    }
    
    private Block<Document> print(){
        return new Block<Document>(){
            @Override
            public void apply(final Document document){
                System.out.println(document.toJson());
            }
        };
    }
    
//    public Collection<DTOLocation> getLocations(Collection<String> location){
//        Collection collection = new ArrayList<>();
//        MongoCollection<Document> locationCollection = connect.collection;
//        Collection<Document> locations = locationCollection.find().into(new ArrayList<Document>());
//        
//        for(Document object : locations){
//            System.out.println(object);
//            
//        }
//        
//        return collection;
//        
//    }
    
    
       public Collection<DTOAuthorBook> getBooksByCity(String location){
           Collection<DTOAuthorBook> collection = new ArrayList<>();
           FindIterable<Document> documents = connect.getCollection("books").find(eq("locations", location));
           
           for(Document document : documents){
               collection.add(new DTOAuthorBook(document.get("name").toString(), document.get("author").toString()));
               System.out.println(document);
           }

           

           return collection;
       }
}
