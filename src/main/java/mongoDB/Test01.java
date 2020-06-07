package mongoDB;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.*;

public class Test01 {
    private static MongoClient client;
    private static MongoDatabase db;
    private static String db_java = "db_java";
    private static String col = "col";
    private static String col2 = "col2";

    public static void main(String[] args) {
        init("db1");
//        db.createCollection(db_java);
//        collections();
        documents();
//        db.createCollection(col2);
//        MongoCollection<Document> collection = db.getCollection(col2);
//        FindIterable<Document> id = collection.find(Filters.eq("_id", new ObjectId("5eb2831906f60929d0490a5b")));
//        id.forEach((Block<? super Document>) doc->{
//            System.out.println(doc);
//        });
//        System.out.println(id);


//        Map<String ,Object> map = new HashMap<>();
//        map.put("k1","v1");
//        map.put("k2","v2");
//        map.put("k3","v3");
//        Document document = new Document(map);
//        collection.insertOne(document);


//        collection.insertMany(null);


    }

    private static void documents(){
        MongoCollection<Document> collection = db.getCollection(col);
        FindIterable<Document> documents = collection.find();
//        UpdateResult updateResult = collection.updateMany(Filters.eq("likes", 150), new Document("$set", new Document("by", "tw")));
//        Filters.eq("","")
        Document document = null;
        FindIterable<Document> documents1 = collection.find(Filters.and(Filters.eq("likes", 150), Filters.eq("by", "tw")));
        Bson likes = Filters.eq("likes", 100);
        Bson or = Filters.or(Filters.eq("_id", new ObjectId("5eb26bfeea5e0000ad000f8c")), Filters.eq("title", false));
        Bson and = Filters.and(likes, or);
        Bson and1 = Filters.or(Filters.eq("_id", new ObjectId("5eb26a88ea5e0000ad000f89")), Filters.eq("title", false));
        FindIterable<Document> documents2 = collection.find(and);
//        System.out.println(updateResult);
        for (Document doc:documents2) {
            System.out.println(doc);
        }
    }


    private static void collections(){
        MongoIterable<String> strings = db.listCollectionNames();
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private static void init(String database) {
        client = new MongoClient("192.168.75.128", 27017);
        db = client.getDatabase(database);

//        ServerAddress serverAddress1 = new ServerAddress("mongo01",0000);
//        ServerAddress serverAddress2 = new ServerAddress("mongo02",0000);
//        ServerAddress serverAddress3 = new ServerAddress("mongo03",0000);
//        List<ServerAddress> list = new ArrayList<>();
//        list.add(serverAddress1);
//        list.add(serverAddress2);
//        list.add(serverAddress3);
//
//        new MongoClient(list);



    }
}
