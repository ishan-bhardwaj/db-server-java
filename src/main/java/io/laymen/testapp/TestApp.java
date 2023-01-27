package io.laymen.testapp;

import io.laymen.raw.FileHandler;
import io.laymen.raw.Person;

public class TestApp {

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("dbserver.db");
            fh.add("Aman", 45, "Delhi", "benz-105", "Description");
            fh.close();

            fh = new FileHandler("dbserver.db");
            Person person = fh.readRow(0);
            fh.close();

            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
