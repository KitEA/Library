package com.kit.library;

import com.google.common.base.MoreObjects;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class User {

    @Element
    private String name;

    @Element
    private String surname;

    @Element
    private String login;

    @Element
    private String password;

    @Element
    private String mail;


    public User(String name, String surname, String login, String password, String mail) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("surname", surname)
                .add("login", login)
                .add("password", password)
                .add("mail", mail)
                .toString();
    }
}
