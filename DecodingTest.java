package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FilterWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DecodingTest {

    @Test
    void read() throws IOException {
        char[] array ={'d', 'e', 'f', 'g'};
        Decoding decode = new Decoding(new FileReader("file"), '0');
        char[] expected = {'q', 'r', 's', 't'};
        char[] actual = new char[4];
        decode.read(actual);
        decode.close();

        assertArrayEquals(expected, actual);
    }
}