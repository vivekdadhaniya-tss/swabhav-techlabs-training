package com.tss.ass1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        String path = "C:\\Users\\vivek.dadhaniya\\Documents\\swabhav-techlabs-training\\code\\03-FileHandling\\src\\com\\tss\\ass1\\test.txt";
//        String path = "C:\\Users\\vivek.dadhaniya\\Documents\\swabhav-techlabs-training\\code\\03-FileHandling\\src\\com\\tss\\ass1\\practice";

        String path = "test.txt";
        try {
            File file = new File(path);
            if (file.isFile()) {
                readFile(file);
            } else if (file.isDirectory()) {
                System.out.println("Path is directory\n");
                System.out.println("Main directory: " + file.getName() + "\n");
                readDirectory(file);
            } else {
                System.out.println("Not valid path");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(File file) throws IOException {
        System.out.println("Path is file");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        if (file.isFile()) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        br.close();
    }

    public static void readDirectory(File file) throws IOException{
        File[] files = file.listFiles();
        if (files == null) return;
        for (File f : files) {
            if(f.isFile()) {
                System.out.println(f.getName());
            } else if (f.isDirectory()) {
                System.out.println("Sub Directory: " + f.getName());
                readDirectory(f);
            }
        }
    }
}
