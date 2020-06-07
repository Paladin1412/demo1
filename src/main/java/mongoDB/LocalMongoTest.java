package mongoDB;


import com.alibaba.fastjson.JSON;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Pattern;

public class LocalMongoTest {
    private String ip = "127.0.0.1";
    private int port = 27017;
    MongoClient client;


    LocalMongoTest() {
        client = new MongoClient(ip, port);
    }

    public void dbs() {
        MongoIterable<String> dbs = client.listDatabaseNames();

        MongoCursor<String> cursor = dbs.iterator();
        while (cursor.hasNext())
            System.out.println(cursor.next());
    }

    public MongoDatabase collections(String db) {
        if (db == null) {
            db = "db01";
        }
        MongoDatabase database = client.getDatabase(db);
        MongoIterable<String> collectionNames = database.listCollectionNames();
        MongoCursor<String> iterator = collectionNames.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        return database;
    }

    public MongoCollection<Document> collection(String db, String collection) {
        if (db == null || collection == null) {
            db = "db01";
            collection = "col01";
        }
        MongoDatabase collections = collections(db);
        return collections.getCollection(collection);
    }

    public void showDocs(FindIterable<Document> documents) {
        MongoCursor<Document> iterator = documents.iterator();
        int i = 0;
        while (iterator.hasNext())
            System.out.println(iterator.next() + "   " + (++i));
    }

    public FindIterable<Document> find() {
        return find(null);
    }


    public FindIterable<Document> find(Bson params) {
        FindIterable<Document> documents;
        MongoCollection<Document> col01 = collection(null, null);

        if (params == null) {

            documents = col01.find();
            System.out.println(col01.countDocuments());
        } else {
            documents = col01.find(params);
            System.out.println(col01.countDocuments(params));
        }

        return documents;
    }

    public FindIterable<Document> findAndSrot(Bson params, Bson sort) {
        Pattern pattern = Pattern.compile("a+");
        Bson expr = Filters.expr(pattern);
        return find(params).sort(expr);
    }

    public void insert(@NotNull Col01... col01s) {
        MongoCollection<Document> collection = collection(null, null);
        List<Document> documents = new ArrayList<>();
        for (Col01 col01 : col01s) {
            documents.add(new Document((Map<String, Object>) JSON.toJSON(col01)));
        }
        collection.insertMany(documents);
    }
    public void createIndex(){
//        MongoCollection<Document> collection = collection(null, null);
//        collection.createIndex();
//        collection.createIndex()
    }


    public static void main(String[] args) {
        LocalMongoTest mongo = new LocalMongoTest();
//        mongo.dbs();
//        mongo.collections(null);
//        MongoCollection<Document> collection = mongo.collection(null, null);
        Bson age = Filters.in("age", 16, 17, 18);
        mongo.showDocs(mongo.find(age));
        System.out.println("-----------------");

        Bson name = Filters.exists("name");
        FindIterable<Document> documents = mongo.find(name);
//
//        Col01 col01 = new Col01("李小龙", 99, "男");
//        Col01 col02 = new Col01("李白", 999, "男");
//        Col01 col03 = new Col01("纯白", 25, "男");
//        mongo.insert(col01, col02, col03);
//        Col01 col = new Col01();
//        System.out.println(col);
//        mongo.insert(col);

        System.out.println("----------------------------------------------------------------");
        mongo.showDocs(mongo.find());
    }
}
