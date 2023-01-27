package io.laymen.raw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandler {

    private RandomAccessFile dbFile;

    public FileHandler(final String dbFileName) throws FileNotFoundException {
        this.dbFile = new RandomAccessFile(dbFileName, "rw");
    }

    public boolean add(
            String name,
            int age,
            String address,
            String carPlateNumber,
            String description) throws IOException {

        // seek to the end of the file
        this.dbFile.seek(this.dbFile.length());

        /*
          Things to write along with the record:
          - isDeleted: byte
          - record length: int
          - name length: int
          - name
          - address length: int
          - address
          - carPlateNumber length: int
          - carPlateNumber
          - description length: int
          - description
         */
        // calculate record length
        int length = 4 + // name length
                name.length() +
                4 + // age
                4 + // address length
                address.length() +
                4 + // carPlateNumber length
                carPlateNumber.length() +
                4 + // description length
                description.length();

        // whether it is deleted
        this.dbFile.writeBoolean(false);    // false because it's a new record
        // record length
        this.dbFile.writeInt(length);
        // store name
        this.dbFile.writeInt(name.length());
        this.dbFile.write(name.getBytes());
        // store age
        this.dbFile.writeInt(age);
        // store address
        this.dbFile.writeInt(address.length());
        this.dbFile.write(address.getBytes());
        // store car plate number
        this.dbFile.writeInt(carPlateNumber.length());
        this.dbFile.write(carPlateNumber.getBytes());
        // store description
        this.dbFile.writeInt(description.length());
        this.dbFile.write(description.getBytes());

        return true;
    }

    public void close() throws IOException {
        this.dbFile.close();
    }

}
