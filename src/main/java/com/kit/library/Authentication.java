package com.kit.library;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class Authentication {

    /*private Path getResource(String fileName) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        return Paths.get(url.toURI());                  //todo: should I care about it?
    }

    public boolean authenticate(String login, String password) {
        try {
            Path resource = getResource("AuthenticationData.txt");
            List<String> list = Files.lines(resource).collect(Collectors.toList());
            return list.contains(login) && list.contains(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isAdmin(){
        return authenticate("Kit", "1237qua");
    }*/

    public boolean authenticate(String login, String password) {
        try {
            Serializer serializer = new Persister();
            File source = new File("userList.xml");

            AuthenticationList authenticationList = serializer.read(AuthenticationList.class, source);

            User user = authenticationList.getUserByLogin(login);

            if(user != null && user.getPassword().equals(password)){
                return true;
            }
            else return false;

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isAdmin(){
        return authenticate("Kit", "1237qua");
    }
}
