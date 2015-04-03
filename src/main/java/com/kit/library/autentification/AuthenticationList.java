package com.kit.library.autentification;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class AuthenticationList {

    @ElementList
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public User getUserByLogin(String login) {
        for (User user : list) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }

        return null;
    }

}
