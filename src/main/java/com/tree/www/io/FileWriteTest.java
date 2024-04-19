package com.tree.www.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author crystal
 * @since 2021/11/16
 */
public class FileWriteTest {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 10; i++) {
            writeSQL("adjjj:" + i + "\n");
        }
    }

    public static void writeSQL(String data) throws IOException {
        File file = new File("yp_sql.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWritter = new FileWriter(file.getName(), true);
        fileWritter.write(data);
        fileWritter.close();
    }

}