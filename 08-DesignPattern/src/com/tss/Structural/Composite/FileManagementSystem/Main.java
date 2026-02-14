package com.tss.Structural.Composite.FileManagementSystem;

public class Main {
    public static void main(String[] args) {

        Folder root = new Folder("Root");

        Folder documents = new Folder("Documents");
        documents.add(new File("Resume.pdf", 200));
        documents.add(new File("Photo.jpg", 500));

        Folder downloads = new Folder("Downloads");
        downloads.add(new File("Movie.mp4", 1000));

        root.add(documents);
        root.add(downloads);
        root.add(new File("System.log", 50));

        // ls
        System.out.println("---- LS ----");
        root.ls(0);

        // getSize
        System.out.println("\nTotal Size of Root: " + root.getSize() + "KB");

        // openAll
        System.out.println("\n---- OPEN ALL ----");
        root.openAll();

        // cd
        System.out.println("\n---- CD to Documents ----");
        FileSystemItem folder = root.cd("Documents");
        if (folder != null) {
            folder.ls(0);
        }
    }
}
