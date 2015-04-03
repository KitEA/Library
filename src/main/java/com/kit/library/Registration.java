package com.kit.library;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.ArrayList;

public class Registration {

    public void registrate(String FirstName, String SecondName, String login,
                           String password, String email) {
        try {
            Serializer serializer = new Persister();
            File source = new File("userList.xml");

            AuthenticationList authenticationList = serializer.read(AuthenticationList.class, source);
            //AuthenticationList authenticationList = new AuthenticationList();
            //authenticationList.setList(new ArrayList<User>());

            User user = new User(FirstName, SecondName, login, password, email);
            authenticationList.getList().add(user);

            File result = new File("userList.xml");

            serializer.write(authenticationList, result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*    public void registrate(String FirstName, String SecondName, String login,
                           String password, String email, String passwordEmail) {
        try {
            BufferedWriter registrationWriter = new BufferedWriter(new FileWriter("AuthenticationData.txt", true));

            registrationWriter.write(FirstName + "\n");
            registrationWriter.write(SecondName + "\n");
            registrationWriter.write(login + "\n");
            registrationWriter.write(password + "\n");
            registrationWriter.write(email + "\n");
            registrationWriter.write("pass" + "\n");
            registrationWriter.write(passwordEmail + "\n");
            registrationWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void registrate(String FirstName, String SecondName, String login, String password, String email) {
        try {
            BufferedWriter registrationWriter = new BufferedWriter(new FileWriter("AuthenticationData.txt", true));

            registrationWriter.write(FirstName + "\n");
            registrationWriter.write(SecondName + "\n");
            registrationWriter.write(login + "\n");
            registrationWriter.write(password + "\n");
            registrationWriter.write(email + "\n");
            registrationWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
