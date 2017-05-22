package DataAccess;

import DTO.DTOAuthorBook;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class MongoMapping {

    private MongoDatabase connect = DBconnectorMongo.getDBConnection();

    //private DBconnectorMongo connect;
//    public MongoMapping(){
//        connect = new DBconnectorMongo();
//        connect.initiate();
//    }
    private Block<Document> print() {
        return new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
    }
    
    
//    public List<DTOAuthorBook> test(final String location) {
//        List<DTOAuthorBook> result = new ArrayList<>();
//        FindIterable<Document> documents = connect.getCollection("books").find(eq("locations", location));
//
//        for (Document document: documents) {
//            result.add(new DTOAuthorBook(document.get("title").toString(), document.get("author").toString()));
//        }
//
//        return result;
//    }

    public List<DTOAuthorBook> getBooksByCity(String location) {

        List<DTOAuthorBook> collection = new ArrayList<>();
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("dbbooks");

        MongoCollection<Document> col = database.getCollection("books");

        try (MongoCursor<Document> cur = col.find(eq("locations.name", location)).iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                List list = new ArrayList(doc.values());

                System.out.println(list.get(2));

            }
        }

        mongoClient.close();
        return collection;
    }
    
    public void getBooksByAuthor(String author) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("dbbooks");

        MongoCollection<Document> col = database.getCollection("books");

        try (MongoCursor<Document> cur = col.find(eq("author.name", author)).iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                List list = new ArrayList(doc.values());

                System.out.println(list.get(2));

            }
        }

        mongoClient.close();
    }
    
     public void getLocationByTitle(String title) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("dbbooks");

        MongoCollection<Document> col = database.getCollection("books");

        try (MongoCursor<Document> cur = col.find(eq("title", title)).iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                List list = new ArrayList(doc.values());

                System.out.println(list.get(4));

            }
        }

        mongoClient.close();
    }
     



}