
package DataAccess;

import DTO.DTOLocation;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;



public class MongoMapping {

    
    private DBconnectorMongo connect;
    
    public MongoMapping(){
        connect = new DBconnectorMongo();
        connect.initiate();
    }
    
    private Block<Document> print(){
        return new Block<Document>(){
            @Override
            public void apply(final Document document){
                System.out.println(document.toJson());
            }
        };
    }
    
//    public Collection<DTOLocation> test(Collection<String> location){
//        
//        Collection collection = new ArrayList<>();
//        
//        MongoCollection<Document> locationCollection = 
//    }
    
}
