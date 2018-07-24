package com.vi.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDemo {

    public static void main(String args[]) {

        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // Now connect to your databases
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongo4vi-27017");

            System.out.println("Connect to database successfully!");
            System.out.println("MongoDatabase inof is : "+mongoDatabase.getName());
            // If MongoDB in secure mode, authentication is required.
            // boolean auth = db.authenticate(myUserName, myPassword);
            // System.out.println("Authentication: "+auth);
//            mongoDatabase.createCollection("collection-person");
//            System.out.println("集合创建成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("collection-person");
            System.out.println("集合 test 选择成功");
            //插入文档
            Document document = new Document("name", "chen").
                    append("age", 99).
                    append("likes", "swing").
                    append("sexual", "man");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }









}
