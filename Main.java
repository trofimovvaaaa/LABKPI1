package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("file");
        char[] array = {'A', 'B', 'C', 'D'};
        Coding coding = new Coding(new FileWriter(file), '0');
        coding.write(array);
        coding.close();
        for (char element:array) {
            System.out.println(element);
        }
        Decoding decoding = new Decoding(new FileReader(file), '0');
        decoding.read(array);
        decoding.close();
        for (char element:array) {
            System.out.println(element);
        }
    }
}
