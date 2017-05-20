/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import com.mongodb.Block;
import java.util.ArrayList;
import org.bson.BsonValue;
import org.bson.Document;

/**
 *
 * @author mustafahakimi
 */
public class MongoMapping {

//    private DBconnectorMongo connect;
//    
//    public MongoMapping(){
//        connect = new DBconnectorMongo();
//        connect.initiate();
//    }
//
//    private Block<Document> print() {
//        return new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                System.out.println(document.toJson());
//            }
//        };
//    }
//    
//    public void HowManyBooks(){
//        int books = connect.collection.distinct("book", BsonValue.class)
//                .into(new ArrayList<BsonValue>()).size();
//        System.out.println("count books: " + books);
//    }
    
}
