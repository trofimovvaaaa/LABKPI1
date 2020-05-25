package com.company;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class Coding extends FilterWriter {
    private char symbolKey;

    public Coding(Writer out, char symbolKey) {
        super(out);
        this.symbolKey = symbolKey;
    }

    public char getSymbolKey() {
        return symbolKey;
    }

    public void setSymbolKey(char symbolKey) {
        this.symbolKey = symbolKey;
    }
    private char code(char in){
        char result = (char) ((in + symbolKey)%128);
        return result;
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        for (int i=0; i <cbuf.length;i++) {
            cbuf[i] = code(cbuf[i]);
        }
        super.write(cbuf);
    }
}
