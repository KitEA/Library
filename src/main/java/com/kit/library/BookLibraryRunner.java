package com.kit.library;

import com.kit.library.autentification.Authentication;

public class BookLibraryRunner {
    public static void main(String[] args){
        new BookUI( new Authentication());
    }
}
