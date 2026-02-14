package com.tss.Structural.Composite.FileManagementSystem;

public interface FileSystemItem {

    void ls(int indent);

    void openAll();

    int getSize();

    FileSystemItem cd(String name);

    String getName();

    boolean isFolder();
}
