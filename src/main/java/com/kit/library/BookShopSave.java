package com.kit.library;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class BookShopSave {

    public void saveBookShop(File file, DefaultTableModel table, int rowCount, int countColumns) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < countColumns; j++) {
                    writer.write((String) ((((Vector) table.getDataVector().elementAt(i)).elementAt(j))) + "\n");
                }
            }
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
