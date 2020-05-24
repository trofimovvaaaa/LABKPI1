package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = read();
        Collections.sort(list, Comparator.comparing(String::length));
        write(list);
    }
    private static void write(List<String> list) throws IOException{
        FileWriter writer = new FileWriter("D:/Users/Svetlana/test0.txt", false);
        for (String a:list) {
            writer.write(a+'\n');
        }
        writer.flush();

    }
    private static ArrayList<String> read() throws IOException{
        ArrayList<String> list = new ArrayList<String>();
        String element = " ";
        BufferedReader reader = new BufferedReader(new FileReader("D:/Users/Svetlana/test0.txt"));
        while((element=reader.readLine()) != null)
        {
            list.add(element);
        }
        return list;
    }
}
