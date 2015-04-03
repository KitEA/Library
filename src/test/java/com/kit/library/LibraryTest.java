package com.kit.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LibraryTest {

    private static class SomeClass {
        private Set<String> names;

        public Set<String> getNames() {
            if (names == null) {
                names = new HashSet<>();
                names.add("Anton");
                names.add("Kit");
                names.add("Someone");
            }

            return names;
        }

        public boolean checkName(String value) {
            return getNames().contains(value);
        }
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSomething() throws Exception {
        String testName_1 = "Anton";

        SomeClass someClass = new SomeClass();
        boolean result_1 = someClass.checkName(testName_1);
        Assert.assertTrue("Everything is bad", result_1);


    }

    @Test
    public void testName() throws Exception {


    }

    @Test
    public void testSerializeUser() throws Exception {
        Serializer serializer = new Persister();

        User user = new User("Nikita", "Eremenko", "Kit", "1237qua", "kitea@mail.ru");

        File result = new File("user.xml");

        serializer.write(user, result);

    }

    @Test
    public void testDeserializingUser() throws Exception{
        Serializer serializer = new Persister();
        File source = new File("user.xml");

        User user = serializer.read(User.class, source);
        System.out.println(user.toString());
    }

    @Test
    public void testSerializerManyUsers() throws Exception {
        Serializer serializer = new Persister();

        AuthenticationList authenticationList = new AuthenticationList();
        authenticationList.setList(new ArrayList<User>());

        User user1 = new User("John", "Galvinski", "JohnG", "243get", "JG@mail.ru");
        authenticationList.getList().add(user1);
        User user2 = new User("Garri", "Goer", "GarroG", "534set", "GG@mail.ru");
        authenticationList.getList().add(user2);

        File result = new File("userList.xml");

        serializer.write(authenticationList, result);
    }
}
