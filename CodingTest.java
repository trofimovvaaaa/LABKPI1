package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CodingTest {

    @org.junit.jupiter.api.Test
    void write() throws IOException {
        char[] array = {'A', 'B', 'C', 'D'};
        Coding coding = new Coding(new FileWriter("file"),'0');
        char[] expected = {'q', 'r', 's', 't'};
        coding.write(array);
        coding.close();
        FileReader reader = new FileReader("file");
        char[] actual = new char[4];
        reader.read(actual);
        assertArrayEquals(expected, actual);
    }
}