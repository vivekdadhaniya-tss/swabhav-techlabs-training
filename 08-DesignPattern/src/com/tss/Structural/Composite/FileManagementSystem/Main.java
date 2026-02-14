package com.tss.Structural.Composite.FileManagementSystem;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Folder root = new Folder("Root");

        Folder documents = new Folder("Documents");
        documents.add(new File("Resume.pdf", 200));
        documents.add(new File("Photo.jpg", 500));

        Folder downloads = new Folder("Downloads");
        downloads.add(new File("Movie.mp4", 1000));

        root.add(documents);
        root.add(downloads);
        root.add(new File("System.log", 50));

//        // ls
//        System.out.println("---- LS ----");
//        root.ls(0);
//
//        // getSize
//        System.out.println("\nTotal Size of Root: " + root.getSize() + "KB");
//
//        // openAll
//        System.out.println("\n---- OPEN ALL ----");
//        root.openAll();
//
//        // cd
//        System.out.println("\n---- CD to Documents ----");
//        FileSystemItem folder = root.cd("Documents");
//        if (folder != null) {
//            folder.ls(0);
//        }

        // Navigation support
        Folder currentFolder = root;
        Stack<Folder> history = new Stack<>();

        int choice;

        do {
            System.out.println("\n===== FILE MANAGEMENT SYSTEM =====");
            System.out.println("Current Folder: " + currentFolder.getName());
            System.out.println("1. List contents (ls)");
            System.out.println("2. Get total size");
            System.out.println("3. Open all files");
            System.out.println("4. Change directory (cd)");
            System.out.println("5. Go back (cd ..)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n---- LS ----");
                    currentFolder.ls(0);
                    break;

                case 2:
                    System.out.println("\nTotal Size: " + currentFolder.getSize() + " KB");
                    break;

                case 3:
                    System.out.println("\n---- OPEN ALL ----");
                    currentFolder.openAll();
                    break;

                case 4:
                    System.out.print("Enter folder name: ");
                    String folderName = scanner.nextLine();
                    FileSystemItem item = currentFolder.cd(folderName);

                    if (item instanceof Folder) {
                        history.push(currentFolder);
                        currentFolder = (Folder) item;
                    } else {
                        System.out.println("Folder not found!");
                    }
                    break;

                case 5:
                    if (!history.isEmpty()) {
                        currentFolder = history.pop();
                    } else {
                        System.out.println("Already at root folder!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}
