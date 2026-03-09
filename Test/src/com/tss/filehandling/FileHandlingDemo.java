package com.tss.filehandling;

import java.io.*;
import java.util.ArrayList;

public class FileHandlingDemo {

    public static void main(String[] args) {

        // ===== 1. FileWriter & FileReader (Character Stream) =====
        try {
            // Write
            FileWriter fw = new FileWriter("charfile.txt");
            fw.write("Hello FileWriter!\nThis is character stream.\n");
            fw.close();

            // Read
            FileReader fr = new FileReader("charfile.txt");
            int ch;
            System.out.println("Reading FileWriter content:");
            while((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
            System.out.println("\n");
        } catch(IOException e) {
            e.printStackTrace();
        }

        // ===== 2. BufferedWriter & BufferedReader (Efficient Character Stream) =====
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedfile.txt"));
            bw.write("Hello BufferedWriter!\nEfficient writing.\n");
            bw.newLine();
            bw.write("Second line here.");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("bufferedfile.txt"));
            String line;
            System.out.println("Reading BufferedWriter content:");
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            System.out.println();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // ===== 3. ObjectOutputStream & ObjectInputStream (Serialize Objects) =====
        try {
            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student("Alice", 22));
            students.add(new Student("Bob", 24));

            // Write objects
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.obj"));
            oos.writeObject(students);
            oos.close();

            // Read objects
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.obj"));
            ArrayList<Student> readStudents = (ArrayList<Student>) ois.readObject();
            ois.close();

            System.out.println("Reading ObjectOutputStream content:");
            for(Student s : readStudents) {
                System.out.println(s);
            }

        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}