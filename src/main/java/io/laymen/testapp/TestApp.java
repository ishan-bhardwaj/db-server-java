package io.laymen.testapp;

import io.laymen.raw.FileHandler;

public class TestApp {

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("dbserver.db");
            fh.add("Aman", 45, "Delhi", "benz-105", "Description");
            fh.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
