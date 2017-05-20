package DataAccess;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import org.bson.Document;

public class DBconnectorMongo {

//    public MongoClient client;
//    public MongoDatabase database;
//    public MongoCollection<Document> collection;
//
//    public Connection getConnection() {
//
//        Connection con = null;
//        try {
//            client = new MongoClient("localhost", 27017);
//            database = client.getDatabase("dbbooks");
//            collection = database.getCollection("books");
//        } catch (Exception e) {
//            System.out.println("error in Mongo DBConnector.getConnection()");
//            System.out.println(e.getMessage());
//        }
//
//        return con;
//    }
    
    public MongoClient client;
    public MongoDatabase database;
    public MongoCollection<Document> collection;

    public void initiate() {
        client = new MongoClient("localhost", 27017);
        database = client.getDatabase("dbbooks");
        collection = database.getCollection("books");
    }
}
