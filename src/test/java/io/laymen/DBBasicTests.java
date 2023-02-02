package io.laymen;

import io.laymen.dbserver.DB;
import io.laymen.dbserver.DBServer;
import io.laymen.raw.Index;
import io.laymen.raw.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class DBBasicTests {

    private DB db;
    private String dbFileName = "test_db.db";

    @Test
    public void testAdd() {
        try {
            this.db.add("Aman", 45, "Delhi", "benz-105", "Description");
            Assertions.assertEquals(Index.getInstance().getTotalNumberOfRows(), 1);
        } catch (IOException e) {
            Assertions.fail();
        }
    }

    @Test
    public void testRead() {
        try {
            this.db.add("Aman", 45, "Delhi", "benz-105", "Description");
            Assertions.assertEquals(Index.getInstance().getTotalNumberOfRows(), 1);
            Person person = this.db.read(0);
            Assertions.assertEquals(person.name, "Aman");
            Assertions.assertEquals(person.age, 45);
            Assertions.assertEquals(person.address, "Delhi");
            Assertions.assertEquals(person.carPlateNumber, "benz-105");
            Assertions.assertEquals(person.description, "Description");
        } catch (IOException e) {
            Assertions.fail();
        }
    }

    @Test
    public void testDelete() {
        try {
            this.db.add("Aman", 45, "Delhi", "benz-105", "Description");
            Assertions.assertEquals(Index.getInstance().getTotalNumberOfRows(), 1);
            this.db.delete(0);
            Assertions.assertEquals(Index.getInstance().getTotalNumberOfRows(), 0);
        } catch (IOException e) {
            Assertions.fail();
        }
    }

    @BeforeEach
    public void setup() throws IOException {
        File file = new File(dbFileName);
        if (file.exists()) file.delete();
        this.db = new DBServer(dbFileName);
    }

    @AfterEach
    public void after() {
        try {
            this.db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
