package com.company;

import javax.print.DocFlavor;
import java.io.*;

public class Decoding extends FilterReader {
    private char symbolKey;

    protected Decoding(Reader in, char symbolKey) {
        super(in);
        this.symbolKey = symbolKey;
    }

    protected char getSymbolKey(){
        return symbolKey;
    }
    protected void setSymbolKey(char symbolKey){
        this.symbolKey = symbolKey;
    }
    private char decode(char in){
        return (char)((in - symbolKey+ 128)%128);
    }

    @Override
    public int read(char[] cbuf) throws IOException {
        int count = super.read(cbuf);
        for (int i=0; i <cbuf.length;i++) {
            cbuf[i] = decode(cbuf[i]);
        }
        return count;
    }
}
