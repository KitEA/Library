package com.kit.library.autentification;

import com.kit.library.serializer.Serializer;

import java.util.List;

public class Authentication {

    public void register(User user) {
        AuthenticationList authenticationList = Serializer.read("userList.xml", AuthenticationList.class);
        List<User> list = authenticationList.getList();
        if (!list.contains(user)) {
            list.add(user);
            Serializer.write("userList.xml", authenticationList);
        }
    }

    public boolean authenticate(String login, String password) {
        AuthenticationList authenticationList = Serializer.read("userList.xml", AuthenticationList.class);
        User user = authenticationList.getUserByLogin(login);
        return user != null && user.getPassword().equals(password);
    }

    public boolean isAdmin() {
        return authenticate("Kit", "1237qua");
    }
}
