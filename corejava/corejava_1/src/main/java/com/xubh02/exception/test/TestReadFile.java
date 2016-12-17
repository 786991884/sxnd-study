package com.xubh02.exception.test;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String str;
        str = new TestReadFile().openFile();
        System.out.println(str);
    }

    String openFile() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("d:/a.txt");
        char c = (char) reader.read();
        System.out.println(c);
        return "" + c;
    }
}
