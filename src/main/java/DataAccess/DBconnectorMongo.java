
package DataAccess;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class DBconnectorMongo {
    
    public MongoClient client;
    public MongoDatabase database;
    public MongoCollection<Document> collection;
    
    public void getConnection(){
        
        client = new MongoClient("localhost", 27017);
        database = client.getDatabase("dbbooks");
        collection = database.getCollection("books");
    }
}
