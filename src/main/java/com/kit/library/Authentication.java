package com.kit.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authentication {

    private boolean userExist = false;
    private boolean userIsAdmin = false;

    public boolean authentication(String login, String password) {
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader("AuthenticationData.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(login)) {
                    i++;
                } else if (line.equals(password)) {
                    i++;
                }
            }
            reader.close();

            if (i == 2) {
                userExist = true;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return userExist;
    }

    public boolean adminAuthentication(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("AuthenticationData.txt"))) {
            int j = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Kit") && line.equals(login)) {
                    j++;
                } else if (line.equals("1237qua") && line.equals(password)) {
                    j++;
                }
            }

            if (j == 2) {
                userIsAdmin = true;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return userIsAdmin;
    }
}
