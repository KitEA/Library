package com.kit.library;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BookShopLoad {

    String[] lines = new String[100];
    int counter = 0;

    public void loadBookShop(File file, DefaultTableModel table) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                lines[i] = line;
                counter++;
            }

            counter = counter / 6;

            for (int j = 0; counter > 0; j = j + 6) {
                table.addRow(
                        new Object[]{lines[j], lines[j + 1], lines[j + 2], lines[j + 3], lines[j + 4], lines[j + 5]});
                counter--;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
