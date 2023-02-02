package io.laymen.testapp;

import io.laymen.dbserver.DB;
import io.laymen.dbserver.DBServer;
import io.laymen.raw.Index;
import io.laymen.raw.Person;

public class TestApp {

    public static void main(String[] args) {
        try {
            String dbFile = "dbserver.db";
            DB db = new DBServer(dbFile);

            db.add("Aman", 45, "Delhi", "benz-105", "Description");
            db.close();

            db = new DBServer(dbFile);
            Person person = db.read(0);

            System.out.println("Total number of rows in the database: " + Index.getInstance().getTotalNumberOfRows());
            System.out.println(person);

            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
