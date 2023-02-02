package io.laymen.raw;

import java.util.HashMap;

public final class Index {

    private static Index index;
    // contains row number and the byte position
    private HashMap<Long, Long> rowIndex;
    private long totalRowNumber = 0;

    private Index() {
        this.rowIndex = new HashMap<>();
    }

    public static Index getInstance() {
        if (index == null) {
            index = new Index();
        }
        return index;
    }

    public void add(long bytePosition) {
        this.rowIndex.put(this.totalRowNumber, bytePosition);
        totalRowNumber++;
    }

    public long getBytePosition(long rowNumber) {
        return this.rowIndex.getOrDefault(rowNumber, -1L);
    }

    public void remove(int row) {
        this.rowIndex.remove(row);
        totalRowNumber--;
    }

    public long getTotalNumberOfRows() {
        return this.totalRowNumber;
    }

    public void clear() {
        this.totalRowNumber = 0;
        this.rowIndex.clear();
    }

}
