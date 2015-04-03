package com.kit.library.serializer;

import org.simpleframework.xml.core.Persister;

import java.io.File;

public class Serializer {

    public static <T> T read(String fileName, Class<T> clazz) {
        return read(new File(fileName), clazz);
    }

    public static <T> T read(File file, Class<T> clazz) {
        try {
            return new Persister().read(clazz, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> void write(String fileName, T object) {
        write(new File(fileName), object);
    }

    public static <T> void write(File file, T object) {
        try {
            new Persister().write(object, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
