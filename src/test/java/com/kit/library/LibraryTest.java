package com.kit.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
