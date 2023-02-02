package io.laymen.testapp;

import io.laymen.dbserver.DB;
import io.laymen.dbserver.DBServer;
import io.laymen.raw.Index;

public class TestApp {

    public static void main(String[] args) {
        try {
            final String dbFile = "dbserver.db";
            DB db = new DBServer(dbFile);

            db.add("Aman", 45, "Delhi", "benz-105", "Description");
            System.out.println("Total number of rows in the database: " + Index.getInstance().getTotalNumberOfRows());

            db.delete(0);

            System.out.println("Total number of rows in the database: " + Index.getInstance().getTotalNumberOfRows());
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
